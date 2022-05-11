package web.project.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.project.business.abstracts.SertifikaImageService;
import web.project.business.abstracts.SertifikaService;
import web.project.core.cloudinary.CloudinaryService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.SertifikaImageDao;
import web.project.entities.concretes.SertifikaImage;

@Service
public class SertifikaImageManager implements SertifikaImageService{
	private SertifikaImageDao sertifikaImageDao;
	private CloudinaryService cloudinaryService;
    private SertifikaService sertifikaService;
	
	@Autowired
    public SertifikaImageManager(SertifikaImageDao sertifikaImageDao, CloudinaryService cloudinaryService, SertifikaService sertifikaService) {
        this.sertifikaImageDao = sertifikaImageDao;
        this.cloudinaryService = cloudinaryService;
        this.sertifikaService = sertifikaService;
	}
    
	@Override
    public DataResult<List<SertifikaImage>> getAll() {
        return new SuccessDataResult<List<SertifikaImage>>(this.sertifikaImageDao.findAll(), "Resimler listelendi");
    }
	
	@Override
    public DataResult<SertifikaImage> getById(int sertifikaImageId) {
        if (this.sertifikaImageDao.findById(sertifikaImageId).isEmpty()) {
            return new ErrorDataResult<SertifikaImage>("Girdiğiniz sayıda resim yoktur");
        }else {
            return new SuccessDataResult<SertifikaImage>
                    (this.sertifikaImageDao.getById(sertifikaImageId), "Id'sine göre resim listelendi");
        }
    }
	
	 @Override
	    public Result upload(int sertifikaId, MultipartFile file) {
	        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryService.upload(file).getData(); //Resimi yükleme işlemi yapar
	        SertifikaImage image = new SertifikaImage();
	        image.setSertifika(sertifikaService.getById(sertifikaId).getData()); //Id'yi veritabanında image'ın sertifikaId'sine setler
	        image.setImage(uploadImage.get("url").toString()); //Resimin url'sini veritabanında image'ın afis resmine setler

	        return add(image); //Ekleme
	    }

	    @Override
	    public Result add(SertifikaImage image) {
	    	sertifikaImageDao.save(image);
	        return new SuccessResult("Resim eklendi.");
	    }

	    @Override
	    public Result delete(int sertifikaImageId) {

	    	SertifikaImage image = getById(sertifikaImageId).getData(); //Girilen Id'ye ait veriyi getirir

	        String[] splitImageUrlArray = image.getImage().split("/"); // Url'i ayırır
	        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf("."); //.'dan öncesini ayırır
	        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension); //Resimin publicId'sini bulur

	        cloudinaryService.delete(publicIdOfImage); //publicId'yi cloudinary hesabından siler
	        sertifikaImageDao.deleteById(sertifikaImageId); //Id'yi veritabanından siler
	        return new SuccessResult("Resim silindi.");
	    }
}

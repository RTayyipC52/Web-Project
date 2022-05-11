package web.project.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.project.business.abstracts.EtkinlikImageService;
import web.project.business.abstracts.EtkinlikService;
import web.project.core.cloudinary.CloudinaryService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikImageDao;
import web.project.entities.concretes.EtkinlikImage;

@Service
public class EtkinlikImageManager implements EtkinlikImageService{
	private EtkinlikImageDao etkinlikImageDao;
	private CloudinaryService cloudinaryService;
    private EtkinlikService etkinlikService;
	
	@Autowired
    public EtkinlikImageManager(EtkinlikImageDao etkinlikImageDao, CloudinaryService cloudinaryService, EtkinlikService etkinlikService) {
        this.etkinlikImageDao = etkinlikImageDao;
        this.cloudinaryService = cloudinaryService;
        this.etkinlikService = etkinlikService;
	}
    
	@Override
    public DataResult<List<EtkinlikImage>> getAll() {
        return new SuccessDataResult<List<EtkinlikImage>>(this.etkinlikImageDao.findAll(), "Resimler listelendi");
    }
	
	@Override
    public DataResult<EtkinlikImage> getById(int etkinlik_image_id) {
        if (this.etkinlikImageDao.findById(etkinlik_image_id).isEmpty()) {
            return new ErrorDataResult<EtkinlikImage>("Girdiğiniz sayıda resim yoktur");
        }else {
            return new SuccessDataResult<EtkinlikImage>
                    (this.etkinlikImageDao.getById(etkinlik_image_id), "Id'sine göre resim listelendi");
        }
    }
	
	 @Override
	    public Result upload(int etkinlik_id, MultipartFile file) {
	        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryService.upload(file).getData(); //Resimi yükleme işlemi yapar
	        EtkinlikImage image = new EtkinlikImage();
	        image.setEtkinlik(etkinlikService.getById(etkinlik_id).getData()); //Id'yi veritabanında image'ın etkinlikId'sine setler
	        image.setAfis_resmi(uploadImage.get("url").toString()); //Resimin url'sini veritabanında image'ın afis resmine setler

	        return add(image); //Ekleme
	    }

	    @Override
	    public Result add(EtkinlikImage image) {
	    	etkinlikImageDao.save(image);
	        return new SuccessResult("Resim eklendi.");
	    }

	    @Override
	    public Result delete(int etkinlik_image_id) {

	    	EtkinlikImage image = getById(etkinlik_image_id).getData(); //Girilen Id'ye ait veriyi getirir

	        String[] splitImageUrlArray = image.getAfis_resmi().split("/"); // Url'i ayırır
	        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf("."); //.'dan öncesini ayırır
	        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension); //Resimin publicId'sini bulur

	        cloudinaryService.delete(publicIdOfImage); //publicId'yi cloudinary hesabından siler
	        etkinlikImageDao.deleteById(etkinlik_image_id); //Id'yi veritabanından siler
	        return new SuccessResult("Resim silindi.");
	    }
}

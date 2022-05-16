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
    public DataResult<EtkinlikImage> getById(int etkinlikImageId) {
        if (this.etkinlikImageDao.findById(etkinlikImageId).isEmpty()) {
            return new ErrorDataResult<EtkinlikImage>("Girdiğiniz sayıda resim yoktur");
        }else {
            return new SuccessDataResult<EtkinlikImage>
                    (this.etkinlikImageDao.getById(etkinlikImageId), "Id'sine göre resim listelendi");
        }
    }
	
	 @Override
	    public Result upload(int etkinlikId, MultipartFile file) {
		 if (this.etkinlikImageDao.getByEtkinlik_EtkinlikId(etkinlikId).isEmpty()) {
	        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryService.upload(file).getData(); //Resimi yükleme işlemi yapar
	        EtkinlikImage image = new EtkinlikImage();
	        image.setEtkinlik(etkinlikService.getById(etkinlikId).getData()); //Id'yi veritabanında image'ın etkinlikId'sine setler
	        image.setAfis_resmi(uploadImage.get("url").toString()); //Resimin url'sini veritabanında image'ın afis resmine setler

	        return add(image); //Ekleme
		 }else {
			 return new ErrorDataResult<List<EtkinlikImage>>("Bu etkinliğin resmi bulunmaktadır");
		 }
	    }

	    @Override
	    public Result add(EtkinlikImage image) {
	    	etkinlikImageDao.save(image);
	        return new SuccessResult("Resim eklendi.");
	    }

	    @Override
	    public Result delete(int etkinlikImageId) {

	    	EtkinlikImage image = getById(etkinlikImageId).getData(); //Girilen Id'ye ait veriyi getirir

	        String[] splitImageUrlArray = image.getAfis_resmi().split("/"); // Url'i ayırır
	        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf("."); //.'dan öncesini ayırır
	        String publicIdOfCert = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension); //Resimin publicId'sini bulur

	        cloudinaryService.delete(publicIdOfCert); //publicId'yi cloudinary hesabından siler
	        etkinlikImageDao.deleteById(etkinlikImageId); //Id'yi veritabanından siler
	        return new SuccessResult("Resim silindi.");
	    }

		@Override
		public DataResult<List<EtkinlikImage>> getByEtkinlik_EtkinlikId(int etkinlikId) {
			if (this.etkinlikImageDao.findById(etkinlikId).isEmpty()) {
				return new ErrorDataResult<List<EtkinlikImage>>("Bu Id'ye ait bir kayıt yoktur");
			} else {
	         return new SuccessDataResult<List<EtkinlikImage>>(this.etkinlikImageDao.getByEtkinlik_EtkinlikId(etkinlikId), "EtkinlikId'ye göre data listelendi");
		    }
		}
}

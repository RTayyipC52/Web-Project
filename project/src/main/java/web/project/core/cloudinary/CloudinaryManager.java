package web.project.core.cloudinary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.SuccessDataResult;

public class CloudinaryManager implements CloudinaryService{
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
	
	@Override
    public DataResult<?> upload(MultipartFile multipartFile) {
        try { //Resim yükleme
            Map<?,?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult);
        } catch (IOException e) { //Oluşan hatayı göstermek
            e.printStackTrace();
            return new ErrorDataResult<>();
        }
    }

    @Override
    public DataResult<?> delete(String publicIdOfCert) {

        List<String> publicIdsOfCerts = new ArrayList<String>();
        publicIdsOfCerts.add(publicIdOfCert);

        try { //Cloudinaryden publicID'ye göre resmi siler
            Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfCerts, ObjectUtils.emptyMap());
            return new SuccessDataResult<>(deleteResult);
        } catch (Throwable e) { //Oluşan hatayı göstermek
            e.printStackTrace();
            return new ErrorDataResult<>();
        }
    }
}

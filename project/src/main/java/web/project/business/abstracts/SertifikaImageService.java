package web.project.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.SertifikaImage;

public interface SertifikaImageService{
	DataResult<List<SertifikaImage>> getAll();
	DataResult<SertifikaImage> getById(int sertifika_image_id);
	Result upload(int sertifika_id, MultipartFile file);
    Result add(SertifikaImage sertifikaImage);
    Result delete(int sertifika_image_id);
}

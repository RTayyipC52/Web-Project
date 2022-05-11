package web.project.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.SertifikaImage;

public interface SertifikaImageService{
	DataResult<List<SertifikaImage>> getAll();
	DataResult<SertifikaImage> getById(int sertifikaImageId);
	Result upload(int sertifikaId, MultipartFile file);
    Result add(SertifikaImage sertifikaImage);
    Result delete(int sertifikaImageId);
}

package web.project.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.EtkinlikImage;

public interface EtkinlikImageService{
	DataResult<List<EtkinlikImage>> getAll();
	DataResult<EtkinlikImage> getById(int id);
	Result upload(int etkinlik_id, MultipartFile file);
    Result add(EtkinlikImage etkinlikImage);
    Result delete(int id);
}

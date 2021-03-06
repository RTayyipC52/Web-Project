package web.project.business.abstracts;

import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.dtos.AddEtkinlikDto;

public interface EtkinlikService extends BaseEntityService<Etkinlik>{
	DataResult<Etkinlik> getById(int etkinlikId);
	Result delete(int etkinlikId);
	DataResult<List<Etkinlik>> getBySertifikaImage_SertifikaImageId(int sertifikaImageId);
	Result add(AddEtkinlikDto addEtkinlikDto);
}

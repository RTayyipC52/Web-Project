package web.project.business.abstracts;

import web.project.entities.concretes.Sertifika;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface SertifikaService extends BaseEntityService<Sertifika>{
	DataResult<Sertifika> getById(int sertifika_id);
	Result delete(int sertifika_id);
}

package web.project.business.abstracts;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Etkinlik;

public interface EtkinlikService extends BaseEntityService<Etkinlik>{
	DataResult<Etkinlik> getById(int etkinlik_id);
	Result delete(int etkinlik_id);
}

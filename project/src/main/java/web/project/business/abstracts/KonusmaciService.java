package web.project.business.abstracts;

import web.project.entities.concretes.Konusmaci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface KonusmaciService extends BaseEntityService<Konusmaci>{
	DataResult<Konusmaci> getById(int konusmaciId);
	Result delete(int konusmaciId);
}

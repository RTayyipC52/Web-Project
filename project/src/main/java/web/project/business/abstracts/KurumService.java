package web.project.business.abstracts;

import web.project.entities.concretes.Kurum;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface KurumService extends BaseEntityService<Kurum>{
	DataResult<Kurum> getById(int kurumId);
	Result delete(int kurumId);
}

package web.project.business.abstracts;

import web.project.entities.concretes.Katilimci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface KatilimciService extends BaseEntityService<Katilimci>{
	DataResult<Katilimci> getById(int katilimci_id);
	Result delete(int katilimci_id);
}

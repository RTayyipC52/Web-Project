package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKatilimci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKatilimciService extends BaseEntityService<EtkinlikVeKatilimci> {
	DataResult<EtkinlikVeKatilimci> getById(int etkinlik_katilimci_id);
	Result delete(int etkinlik_katilimci_id);
}

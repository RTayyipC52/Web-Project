package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKatilimci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKatilimciService extends BaseEntityService<EtkinlikVeKatilimci> {
	DataResult<EtkinlikVeKatilimci> getById(int etkinlikKatilimciId);
	Result delete(int etkinlikKatilimciId);
	DataResult<EtkinlikVeKatilimci> getByKatilimci_KatilimciId(int katilimciId);
	DataResult<EtkinlikVeKatilimci> getByEtkinlik_EtkinlikId(int etkinlikId);
}

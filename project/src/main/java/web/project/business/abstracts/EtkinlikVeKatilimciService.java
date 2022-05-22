package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKatilimci;

import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKatilimciService extends BaseEntityService<EtkinlikVeKatilimci> {
	DataResult<EtkinlikVeKatilimci> getById(int etkinlikKatilimciId);
	Result delete(int etkinlikKatilimciId);
	DataResult<List<EtkinlikVeKatilimci>> getByKatilimci_KatilimciId(int katilimciId);
	DataResult<List<EtkinlikVeKatilimci>> getByEtkinlik_EtkinlikId(int etkinlikId);
	DataResult<List<EtkinlikVeKatilimci>> getByKatilimci_User_UserId(int userId);
}

package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKurum;

import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKurumService extends BaseEntityService<EtkinlikVeKurum>{
	DataResult<EtkinlikVeKurum> getById(int etkinlikKurumId);
	Result delete(int etkinlikKurumId);
	DataResult<List<EtkinlikVeKurum>> getByKurum_KurumId(int kurumId);
	DataResult<List<EtkinlikVeKurum>> getByEtkinlik_EtkinlikId(int etkinlikId);
	DataResult<List<EtkinlikVeKurum>> getByKurum_User_UserId(int userId);
	 
}

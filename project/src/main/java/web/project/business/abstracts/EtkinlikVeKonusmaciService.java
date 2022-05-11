package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKonusmaci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKonusmaciService extends BaseEntityService<EtkinlikVeKonusmaci>{
	DataResult<EtkinlikVeKonusmaci> getById(int etkinlikKonusmaciId);
	Result delete(int etkinlikKonusmaciId);
	
	DataResult<EtkinlikVeKonusmaci> getByKonusmaci_KonusmaciId(int konusmaciId); 
	DataResult<EtkinlikVeKonusmaci> getByEtkinlik_EtkinlikId(int etkinlikId);
	 
}

package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKurum;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKurumService extends BaseEntityService<EtkinlikVeKurum>{
	DataResult<EtkinlikVeKurum> getById(int etkinlikKurumId);
	Result delete(int etkinlikKurumId);
	
	DataResult<EtkinlikVeKurum> getByKurum_KurumId(int kurumId);
	DataResult<EtkinlikVeKurum> getByEtkinlik_EtkinlikId(int etkinlikId);
	 
}

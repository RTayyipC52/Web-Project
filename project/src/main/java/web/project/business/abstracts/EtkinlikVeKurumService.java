package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKurum;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKurumService extends BaseEntityService<EtkinlikVeKurum>{
	DataResult<EtkinlikVeKurum> getById(int etkinlik_kurum_id);
	Result delete(int etkinlik_kurum_id);
}

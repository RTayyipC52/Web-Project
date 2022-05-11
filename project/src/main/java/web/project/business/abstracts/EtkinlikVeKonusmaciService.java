package web.project.business.abstracts;

import web.project.entities.concretes.EtkinlikVeKonusmaci;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface EtkinlikVeKonusmaciService extends BaseEntityService<EtkinlikVeKonusmaci>{
	DataResult<EtkinlikVeKonusmaci> getById(int etkinlik_konusmaci_id);
	Result delete(int etkinlik_konusmaci_id);
}

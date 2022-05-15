package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKonusmaci;

public interface EtkinlikVeKonusmaciDao extends JpaRepository<EtkinlikVeKonusmaci, Integer> {
	List<EtkinlikVeKonusmaci> getByEtkinlik_EtkinlikId(int etkinlikId);
	List<EtkinlikVeKonusmaci> getByKonusmaci_KonusmaciId(int konusmaciId);
}

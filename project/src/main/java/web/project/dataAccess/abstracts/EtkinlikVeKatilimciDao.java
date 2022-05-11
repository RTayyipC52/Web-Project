package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKatilimci;

public interface EtkinlikVeKatilimciDao extends JpaRepository<EtkinlikVeKatilimci, Integer> {
	EtkinlikVeKatilimci getByEtkinlik_EtkinlikId(int etkinlikId);
	EtkinlikVeKatilimci getByKatilimci_KatilimciId(int katilimciId);
}

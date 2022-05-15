package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKatilimci;

public interface EtkinlikVeKatilimciDao extends JpaRepository<EtkinlikVeKatilimci, Integer> {
   List<EtkinlikVeKatilimci> getByEtkinlik_EtkinlikId(int etkinlikId);
   List<EtkinlikVeKatilimci> getByKatilimci_KatilimciId(int katilimciId);
}

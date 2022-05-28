package web.project.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKatilimci;

public interface EtkinlikVeKatilimciDao extends JpaRepository<EtkinlikVeKatilimci, Integer> {
   List<EtkinlikVeKatilimci> getByEtkinlik_EtkinlikId(int etkinlikId);
   List<EtkinlikVeKatilimci> getByKatilimci_KatilimciId(int katilimciId);
   List<EtkinlikVeKatilimci> getByKatilimci_User_UserId(int userId);
   List<EtkinlikVeKatilimci> getByEtkinlik_Tarih(LocalDate tarih);
}

package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKurum;

public interface EtkinlikVeKurumDao extends JpaRepository<EtkinlikVeKurum, Integer> {
	List<EtkinlikVeKurum> getByEtkinlik_EtkinlikId(int etkinlikId);
	List<EtkinlikVeKurum> getByKurum_KurumId(int kurumId);
	List<EtkinlikVeKurum> getByKurum_User_UserId(int userId);
}

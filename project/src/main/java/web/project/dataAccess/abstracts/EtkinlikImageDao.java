package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikImage;

public interface EtkinlikImageDao extends JpaRepository<EtkinlikImage, Integer>{
	EtkinlikImage getById(int etkinlikImageId);
	List<EtkinlikImage> getByEtkinlik_EtkinlikId(int etkinlikId);
	EtkinlikImage findByEtkinlik_EtkinlikId(int etkinlikId);
}

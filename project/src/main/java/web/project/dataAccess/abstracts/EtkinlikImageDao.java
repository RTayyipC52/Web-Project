package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikImage;

public interface EtkinlikImageDao extends JpaRepository<EtkinlikImage, Integer>{
	EtkinlikImage getById(int etkinlikImageId);
}

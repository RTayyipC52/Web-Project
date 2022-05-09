package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.SertifikaImage;

public interface SertifikaImageDao extends JpaRepository<SertifikaImage, Integer>{
	SertifikaImage getById(int id);
}

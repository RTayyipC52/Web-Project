package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.SertifikaImage;

public interface SertifikaImageDao extends JpaRepository<SertifikaImage, Integer>{
	SertifikaImage getById(int sertifikaImageId);
	List<SertifikaImage> getBySertifika_SertifikaId(int sertifikaId);
	SertifikaImage findBySertifika_SertifikaId(int sertifikaId);
}

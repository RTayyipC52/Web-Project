package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Etkinlik;

public interface EtkinlikDao extends JpaRepository<Etkinlik, Integer> {
	Etkinlik getBySertifika_SertifikaId(int sertifikaId);
}

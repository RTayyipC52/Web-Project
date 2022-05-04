package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Sertifika;

public interface SertifikaDao extends JpaRepository<Sertifika, Integer> {

}

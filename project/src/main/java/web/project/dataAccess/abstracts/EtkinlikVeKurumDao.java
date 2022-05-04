package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKurum;

public interface EtkinlikVeKurumDao extends JpaRepository<EtkinlikVeKurum, Integer> {

}

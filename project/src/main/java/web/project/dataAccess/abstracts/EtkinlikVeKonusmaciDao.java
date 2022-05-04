package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.EtkinlikVeKonusmaci;

public interface EtkinlikVeKonusmaciDao extends JpaRepository<EtkinlikVeKonusmaci, Integer> {

}

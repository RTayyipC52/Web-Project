package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Konusmaci;

public interface KonusmaciDao extends JpaRepository<Konusmaci, Integer> {

}

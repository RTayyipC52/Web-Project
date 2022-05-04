package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Katilimci;

public interface KatilimciDao extends JpaRepository<Katilimci, Integer> {

}

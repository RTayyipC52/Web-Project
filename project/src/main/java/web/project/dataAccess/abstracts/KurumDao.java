package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Kurum;

public interface KurumDao extends JpaRepository<Kurum, Integer> {

}

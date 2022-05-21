package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Kurum;

public interface KurumDao extends JpaRepository<Kurum, Integer> {
	List<Kurum> getByUser_UserId(int userId);
	Kurum findByUser_UserId(int userId);
}

package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Katilimci;

public interface KatilimciDao extends JpaRepository<Katilimci, Integer> {
	List<Katilimci> getByUser_UserId(int userId);
	Katilimci findByUser_UserId(int userId);
}

package web.project.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import web.project.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}

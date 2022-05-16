package web.project.business.abstracts;

import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
    DataResult<User> getById(int userId);
}

package web.project.business.abstracts;

import java.util.List;

import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.dtos.UserLoginDto;
import web.project.entities.dtos.UserLoginReturnDto;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
    DataResult<User> getById(int userId);
    DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto);
    DataResult<List<User>> getAll();
}

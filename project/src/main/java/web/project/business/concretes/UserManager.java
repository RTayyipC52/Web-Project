package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.business.abstracts.UserService;
import web.project.core.dataAccess.UserDao;
import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
@Service
public class UserManager implements UserService {

    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Kullanici eklendi.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {

        return new SuccessDataResult<User>(this.userDao.findByEmail(email),
        "Kullanici bulundu.");
    }
}

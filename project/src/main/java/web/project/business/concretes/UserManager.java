package web.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.business.abstracts.UserService;
import web.project.core.dataAccess.UserDao;
import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KatilimciDao;
import web.project.dataAccess.abstracts.KurumDao;
import web.project.entities.dtos.UserLoginDto;
import web.project.entities.dtos.UserLoginReturnDto;
@Service
public class UserManager implements UserService {

    private UserDao userDao;
    private KurumDao kurumDao;
    private KatilimciDao katilimciDao;
    @Autowired
    public UserManager(UserDao userDao,KurumDao kurumDao,KatilimciDao katilimciDao) {
        super();
        this.userDao = userDao;
        this.katilimciDao = katilimciDao;
        this.kurumDao = kurumDao;
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

	@Override
	public DataResult<User> getById(int userId) {
		if (this.userDao.findById(userId).isEmpty()){
            return new ErrorDataResult<User>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<User>(this.userDao.getById(userId), "Id'ye göre data listelendi");
        }
	}

	@Override
	public DataResult<UserLoginReturnDto> login(UserLoginDto userLoginDto) {
		User user = this.userDao.findByEmail(userLoginDto.getEmail());
        if(user==null){
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı email girdiniz");
        }else if(!user.getPassword().equals(userLoginDto.getPassword())){
            return new ErrorDataResult<UserLoginReturnDto>("Hatalı şifre girdiniz");
        }
        UserLoginReturnDto userLoginReturnDto = new UserLoginReturnDto();
        userLoginReturnDto.setUserId(user.getUserId());
        userLoginReturnDto.setEmail(user.getEmail());
        
        if(this.kurumDao.getByUser_UserId(user.getUserId()).isEmpty()){
            userLoginReturnDto.setUserType(1);
            userLoginReturnDto.setName(this.katilimciDao.findByUser_UserId(user.getUserId()).getKatilimci_ad()+" "+this.katilimciDao.findByUser_UserId(user.getUserId()).getKatilimci_soyad());
           
        }else if(this.katilimciDao.getByUser_UserId(user.getUserId()).isEmpty()){
            userLoginReturnDto.setUserType(2);
            userLoginReturnDto.setName(this.kurumDao.findByUser_UserId(user.getUserId()).getKurumAd());
            
        }else {
            return new ErrorDataResult<UserLoginReturnDto>("Bir hata oluştu");
        }

        return new SuccessDataResult<UserLoginReturnDto>(userLoginReturnDto,"Giriş yapıldı");
}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar listelendi");
	}
}

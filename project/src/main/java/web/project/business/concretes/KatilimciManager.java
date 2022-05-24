package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.KatilimciService;
import web.project.business.abstracts.UserService;
import web.project.core.dataAccess.UserDao;
import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.ErrorResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KatilimciDao;
import web.project.entities.concretes.Katilimci;
import web.project.entities.dtos.KatilimciRegisterDto;

import java.util.List;

@Service
public class KatilimciManager implements KatilimciService {
    private KatilimciDao katilimciDao;
    private UserDao userDao;
    private UserService userService;

    @Autowired
    public KatilimciManager(KatilimciDao katilimciDao, UserDao userDao, UserService userService) {
        this.katilimciDao = katilimciDao;
        this.userDao = userDao;
        this.userService = userService;
    }

    @Override
    public DataResult<List<Katilimci>> getAll() {
        return new SuccessDataResult<List<Katilimci>>
                (this.katilimciDao.findAll(),"Katilimcilar listelendi");
    }

    @Override
    public Result add(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("Katilimci eklendi");
    }

    @Override
    public Result update(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("Katilimci güncellendi");
    }
    @Override
    public Result delete(int katilimciId){
        this.katilimciDao.deleteById(katilimciId);
        return new SuccessResult("Katilimci silindi");
    }
    
    @Override
    public DataResult<Katilimci> getById(int katilimciId) {
        if (this.katilimciDao.findById(katilimciId).isEmpty()){
            return new ErrorDataResult<Katilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Katilimci>(this.katilimciDao.getById(katilimciId), "Id'ye göre data listelendi");
        }
    }

	@Override
	public DataResult<Katilimci> getByUser_UserId(int userId) {
		if (this.katilimciDao.getByUser_UserId(userId).isEmpty()){
            return new ErrorDataResult<Katilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Katilimci>(this.katilimciDao.findByUser_UserId(userId), "Id'ye göre data listelendi");
        }
	}

	@Override
	public Result add(KatilimciRegisterDto katilimciRegisterDto) {
		User user = new User();
		user.setEmail(katilimciRegisterDto.getEmail());
		user.setPassword(katilimciRegisterDto.getPassword());
		
		if(userService.findByEmail(user.getEmail()).getData() != null) {
			return new ErrorResult("Bu email zaten kayıtlı");
		}else if(user.getPassword().length() <= 5 ){
	        return new ErrorResult("Şifre 5 karakterden uzun olmalıdır.");
	    }
		
		Katilimci katilimci = new Katilimci();
		katilimci.setKatilimci_ad(katilimciRegisterDto.getKatilimci_ad());
		katilimci.setKatilimci_soyad(katilimciRegisterDto.getKatilimci_soyad());
		katilimci.setTelefon(katilimciRegisterDto.getTelefon());
		katilimci.setUniversite(katilimciRegisterDto.getUniversite());
		katilimci.setBolum(katilimciRegisterDto.getBolum());
		katilimci.setSinif(katilimciRegisterDto.getSinif());
		katilimci.setOgrenimdurumu(katilimciRegisterDto.getOgrenimdurumu());
		katilimci.setUser(user);

       if(katilimci.getTelefon().length() <10){
           return new ErrorResult("Geçerli bir telefon numarası giriniz.");
       }else if(katilimci.getKatilimci_ad().length()<=2){
           return new ErrorResult("İsminiz 2 karakterden uzun olmalıdır");
       }
       this.userDao.save(user);
       this.katilimciDao.save(katilimci);
       return new SuccessResult("Kurum eklendi");
	}
}
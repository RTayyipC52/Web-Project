package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.KurumService;
import web.project.business.abstracts.UserService;
import web.project.core.dataAccess.UserDao;
import web.project.core.entities.User;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.ErrorResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KurumDao;
import web.project.entities.concretes.Kurum;
import web.project.entities.dtos.KurumRegisterDto;

import java.util.List;

@Service

public class KurumManager implements KurumService {
    private KurumDao kurumDao;
    private UserDao userDao;
    private UserService userService;

    @Autowired
    public KurumManager(KurumDao kurumDao, UserDao userDao, UserService userService) {
        this.kurumDao = kurumDao;
        this.userDao = userDao;
        this.userService = userService;
    }

    @Override
    public DataResult<List<Kurum>> getAll() {
        return new SuccessDataResult<List<Kurum>>
                (this.kurumDao.findAll(),"Kurumlar listelendi");
    }

    @Override
    public Result add(Kurum kurum) {
        this.kurumDao.save(kurum);
        return new SuccessResult("Kurum eklendi");
    }

    @Override
    public Result update(Kurum kurum) {
        this.kurumDao.save(kurum);
        return new SuccessResult("Kurum güncellendi");
    }
    
    @Override
    public Result delete(int kurumId){
        this.kurumDao.deleteById(kurumId);
        return new SuccessResult("Kurum silindi");
    }
    
    @Override
    public DataResult<Kurum> getById(int kurumId) {
        if (this.kurumDao.findById(kurumId).isEmpty()){
            return new ErrorDataResult<Kurum>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Kurum>(this.kurumDao.getById(kurumId), "Id'ye göre data listelendi");
        }
    }

	@Override
	public DataResult<List<Kurum>> getByUser_UserId(int userId) {
		if (this.kurumDao.getByUser_UserId(userId).isEmpty()){
            return new ErrorDataResult<List<Kurum>>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<List<Kurum>>(this.kurumDao.getByUser_UserId(userId), "Id'ye göre data listelendi");
        }
	}

	@Override
	public Result add(KurumRegisterDto kurumRegisterDto) {
		User user = new User();
		user.setEmail(kurumRegisterDto.getEmail());
		user.setPassword(kurumRegisterDto.getPassword());
		
		if(userService.findByEmail(user.getEmail()).getData() != null) {
			return new ErrorResult("Bu email zaten kayıtlı");
		}else if(user.getPassword().length() <= 5 ){
	        return new ErrorResult("Şifre 5 karakterden uzun olmalıdır.");
	    }
		
		Kurum kurum = new Kurum();
		kurum.setKurumAd(kurumRegisterDto.getKurumAd());
		kurum.setKurumAciklama(kurumRegisterDto.getKurumAciklama());
		kurum.setAdres(kurumRegisterDto.getAdres());
		kurum.setYetkiliAd(kurumRegisterDto.getYetkiliAd());
		kurum.setYetkiliSoyad(kurumRegisterDto.getYetkiliSoyad());
		kurum.setYetkiliTel(kurumRegisterDto.getYetkiliTel());
		kurum.setUser(user);

       if(kurum.getYetkiliTel().length() <10){
           return new ErrorResult("Geçerli bir telefon numarası giriniz.");
       }else if(kurum.getKurumAd().length()<=2){
           return new ErrorResult("Kurum adı 2 karakterden uzun olmalıdır");
       }
       this.userDao.save(user);
       this.kurumDao.save(kurum);
       return new SuccessResult("Kurum eklendi");
	}
}
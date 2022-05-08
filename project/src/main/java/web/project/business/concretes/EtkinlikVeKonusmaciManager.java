package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.dataAccess.abstracts.EtkinlikVeKonusmaciDao;
import web.project.entities.concretes.EtkinlikVeKonusmaci;
import web.project.business.abstracts.EtkinlikVeKonusmaciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;

import java.util.List;

@Service
public class EtkinlikVeKonusmaciManager implements EtkinlikVeKonusmaciService {

    private EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao;

    @Autowired
    public EtkinlikVeKonusmaciManager(EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao){
        this.etkinlikVeKonusmaciDao = etkinlikVeKonusmaciDao;
    }
    @Override
    public DataResult<List<EtkinlikVeKonusmaci>> getAll() {
        return new SuccessDataResult<List<EtkinlikVeKonusmaci>>
                (this.etkinlikVeKonusmaciDao.findAll(),"Data Listelendi");
    }
    @Override
    public Result add(EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
        this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
        return new SuccessResult("Kayıt Eklendi");
    }
    @Override
    public Result update(EtkinlikVeKonusmaci etkinlikVeKonusmaci){
        this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
        return new SuccessResult("Kayıt Güncellendi");
    }
    @Override
    public Result delete(int id){
        this.etkinlikVeKonusmaciDao.deleteById(id);
        return new SuccessResult("Kayıt Silindi");
    }
    
    @Override
    public DataResult<EtkinlikVeKonusmaci> getById(int id) {
        if (this.etkinlikVeKonusmaciDao.findById(id).isEmpty()){
            return new ErrorDataResult<EtkinlikVeKonusmaci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<EtkinlikVeKonusmaci>(this.etkinlikVeKonusmaciDao.getById(id), "Id'ye göre data listelendi");
        }
    }
}

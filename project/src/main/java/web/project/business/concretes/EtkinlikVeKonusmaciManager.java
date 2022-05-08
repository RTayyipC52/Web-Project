package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import web.project.dataAccess.abstracts.EtkinlikVeKonusmaciDao;
import web.project.entities.concretes.EtkinlikVeKonusmaci;

import java.util.List;

public class EtkinlikVeKonusmaciManager implements EtkinlikVeKonusmaciService {

    private EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao;

    @Autowired
    public EtkinlikVeKonusmaciManager(EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao){
        this.etkinlikVeKonusmaciDao = etkinlikVeKonusmaciDao;
    }
    @Override
    public DataResult<List<EtkinlikVeKonusmaci>> getAll() {
        return new SuccessDataResult<List<EtkinlikVeKonusmaci>>
                (this.etkinlikVeKonusmaciDao.findAll(),"Listelendi");
    }
    @Override
    public Result add(EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
        this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
        return new SuccessResult("eklendi");
    }
    @Override
    public Result update(EtkinlikVeKonusmaci etkinlikVeKonusmaci){
        this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
        return new SuccessResult("güncellendi");
    }
    @Override
    public Result delete(int ){
        this.etkinlikVeKonusmaciDao.deleteById();
        return new SuccessResult("silindi");
    }













}

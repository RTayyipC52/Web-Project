package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.dataAccess.abstracts.EtkinlikVeKatilimciDao;
import web.project.entities.concretes.EtkinlikVeKatilimci;

import java.util.List;
@Service
public class EtkinlikVeKatilimciManager implements EtkinlikVeKatilimciService{

    private EtkinlikVeKatilimciDao etkinlikVeKatilimciDao;

    @Autowired
    public EtkinlikVeKatilimciManager(EtkinlikVeKatilimciDao etkinlikVeKatilimciDao) {
        this.etkinlikVeKatilimciDao = etkinlikVeKatilimciDao;
    }

    @Override
    public DataResult<List<EtkinlikVeKatilimci>> getAll() {
        return new SuccessDataResult<List<EtkinlikVeKatilimci>>(this.etkinlikVeKatilimciDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(EtkinlikVeKatilimci etkinlikVeKatilimci) {
        this.etkinlikVeKatilimciDao.save(etkinlikVeKatilimci);
        return new SuccessResult("Gklendi");
    }
    @Override
    public Result update(EtkinlikVeKatilimci etkinlikVeKatilimci){
        this.etkinlikVeKatilimciDao.save(etkinlikVeKatilimci);
        return new SuccessResult("Güncellendi");
    }
    @Override
    public Result delete(int ){
        this.etkinlikVeKatilimciDao.deleteById();
        return new SuccessResult("Silindi");
    }

    //get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık












}

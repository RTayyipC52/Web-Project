package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikVeKurumDao;
import web.project.dataAccess.abstracts.KatilimciDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.EtkinlikVeKurum;
import web.project.entities.concretes.Katilimci;

import java.util.List;

@Service
public class KatilimciManager implements KatiliciService {
    private KatilimciDao katilimciDao;

    @Autowired
    public KatilimciManager(KatilimciDao katilimciDao) {
        this.katilimciDao = katilimciDao;
    }

    @Override
    public DataResult<List<Katilimci>> getAll() {
        return new SuccessDataResult<List<Etkinlik>>
                (this.katilimciDao.findAll(),"katilimcilar listelendi");
    }

    @Override
    public Result add(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("katilimci eklendi");
    }

    @Override
    public Result update(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("katilimci güncellendi");
    }
    @Override
    public Result delete(int ){
        this.katilimciDao.deleteById();
        return new SuccessResult("katilimci silindi");
    }

    //get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık








}
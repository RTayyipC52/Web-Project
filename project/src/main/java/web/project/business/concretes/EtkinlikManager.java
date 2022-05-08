package web.project.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikDao;
import web.project.entities.concretes.Etkinlik;

import java.util.List;
@Service

public class EtkinlikManager implements EtkinlikService {
    private EtkinlikDao etkinlikDao;

    @Autowired
    public EtkinlikManager(EtkinlikDao etkinlikDao) {
        this.etkinlikDao = etkinlikDao;
    }

    @Override
    public DataResult<List<Etkinlik>> getAll() {
        return new SuccessDataResult<List<Etkinlik>>
                (this.EtlinlikDao.findAll(),"Etkinlikler listelendi");
    }

    @Override
    public Result add(Etkinlik etkinlik) {
        this.EtkinlikDao.save(etkinlik);
        return new SuccessResult("Etkinlik eklendi");
    }

    @Override
    public Result update(Etkinlik etkinlik) {
        this.EtkinlikDao.save(etkinlik);
        return new SuccessResult("Etkinlik güncellendi");
    }
    @Override
    public Result delete(int ){
        this.EtkinlikDao.deleteById();
        return new SuccessResult("Etkinlik silindi");
    }

    //get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık
























}

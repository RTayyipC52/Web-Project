package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikDao;
import web.project.dataAccess.abstracts.KurumDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.Kurum;

import java.util.List;



@Service

public class KurumManager implements KurumService {
    private KurumDao kurumDao;

    @Autowired
    public KurumManager(KurumDao kurumDao) {
        this.kurumDao = kurumDao;
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
    public Result delete(int ){
        this.kurumDao.deleteById();
        return new SuccessResult("Kurum silindi");
    }

//get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık


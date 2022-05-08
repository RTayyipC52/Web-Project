package web.project.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikVeKurumDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.EtkinlikVeKurum;

import java.util.List;

@Service
public class EtkinlikVeKurumManager implements EtkinlikVeKurumService {
    private EtkinlikVeKurumDao etkinlikVeKurumDao;

    @Autowired
    public EtkinlikVeKurumManager(EtkinlikVeKurumDao etkinlikVeKurumDao) {
        this.etkinlikVeKurumDao = etkinlikVeKurumDao;
    }

    @Override
    public DataResult<List<EtkinlikVeKurum>> getAll() {
        return new SuccessDataResult<List<Etkinlik>>
                (this.etkinlikVeKurumDao.findAll(),"Etkinlikler listelendi");
    }

    @Override
    public Result add(EtkinlikVeKurum etkinlikVeKurum) {
        this.etkinlikVeKurumDao.save(etkinlikVeKurum);
        return new SuccessResult("Etkinlik eklendi");
    }

    @Override
    public Result update(EtkinlikVeKurum etkinlikVeKurum) {
        this.etkinlikVeKurumDao.save(etkinlikVeKurum);
        return new SuccessResult("Etkinlik güncellendi");
    }
    @Override
    public Result delete(int ){
        this.EtkinlikDao.deleteById();
        return new SuccessResult("Etkinlik silindi");
    }

    //get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık








}

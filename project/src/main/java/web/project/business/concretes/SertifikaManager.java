package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikDao;
import web.project.dataAccess.abstracts.SertifikaDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.Sertifika;

import java.util.List;

@Service

public class SertifikaManager implements SerfifikaService {
    private SertifikaDao sertifikaDao;

    @Autowired
    public SertifikaManager(SertifikaDao sertifikaDao) {
        this.sertifikaDao = sertifikaDao;
    }

    @Override
    public DataResult<List<Sertifika>> getAll() {
        return new SuccessDataResult<List<Sertifika>>
                (this.sertifikaDao.findAll(),"Sertifikalar listelendi");
    }

    @Override
    public Result add(Sertifika sertifika) {
        this.sertifikaDao.save(sertifika);
        return new SuccessResult("Sertifika eklendi");
    }

    @Override
    public Result update(Sertifika sertifika) {
        this.sertifikaDao.save(sertifika);
        return new SuccessResult("Sertifika güncellendi");
    }
    @Override
    public Result delete(int ){
        this.sertifikaDao.deleteById();
        return new SuccessResult("Sertifika silindi");
    }

//get fonksıyonu ve delete fonksıyonundakı silinmesi gereken Id degerlerı eksık


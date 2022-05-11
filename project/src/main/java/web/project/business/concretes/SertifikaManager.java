package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.SertifikaService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.SertifikaDao;
import web.project.entities.concretes.Sertifika;

import java.util.List;

@Service

public class SertifikaManager implements SertifikaService {
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
    public Result delete(int sertifika_id){
        this.sertifikaDao.deleteById(sertifika_id);
        return new SuccessResult("Sertifika silindi");
    }
    
    @Override
    public DataResult<Sertifika> getById(int sertifika_id) {
        if (this.sertifikaDao.findById(sertifika_id).isEmpty()){
            return new ErrorDataResult<Sertifika>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Sertifika>(this.sertifikaDao.getById(sertifika_id), "Id'ye göre data listelendi");
        }
    }
}
package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EtkinlikService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
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
                (this.etkinlikDao.findAll(),"Etkinlikler listelendi");
    }

    @Override
    public Result add(Etkinlik etkinlik) {
        this.etkinlikDao.save(etkinlik);
        return new SuccessResult("Etkinlik eklendi");
    }

    @Override
    public Result update(Etkinlik etkinlik) {
        this.etkinlikDao.save(etkinlik);
        return new SuccessResult("Etkinlik güncellendi");
    }
    @Override
    public Result delete(int etkinlikId){
        this.etkinlikDao.deleteById(etkinlikId);
        return new SuccessResult("Etkinlik silindi");
    }
    
    @Override
    public DataResult<Etkinlik> getById(int etkinlikId) {
        if (this.etkinlikDao.findById(etkinlikId).isEmpty()){
            return new ErrorDataResult<Etkinlik>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Etkinlik>(this.etkinlikDao.getById(etkinlikId), "Id'ye göre data listelendi");
        }
    }
}
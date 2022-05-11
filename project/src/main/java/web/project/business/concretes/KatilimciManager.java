package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.KatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KatilimciDao;
import web.project.entities.concretes.Katilimci;

import java.util.List;

@Service
public class KatilimciManager implements KatilimciService {
    private KatilimciDao katilimciDao;

    @Autowired
    public KatilimciManager(KatilimciDao katilimciDao) {
        this.katilimciDao = katilimciDao;
    }

    @Override
    public DataResult<List<Katilimci>> getAll() {
        return new SuccessDataResult<List<Katilimci>>
                (this.katilimciDao.findAll(),"Katilimcilar listelendi");
    }

    @Override
    public Result add(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("Katilimci eklendi");
    }

    @Override
    public Result update(Katilimci katilimci) {
        this.katilimciDao.save(katilimci);
        return new SuccessResult("Katilimci güncellendi");
    }
    @Override
    public Result delete(int katilimci_id){
        this.katilimciDao.deleteById(katilimci_id);
        return new SuccessResult("Katilimci silindi");
    }
    
    @Override
    public DataResult<Katilimci> getById(int katilimci_id) {
        if (this.katilimciDao.findById(katilimci_id).isEmpty()){
            return new ErrorDataResult<Katilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Katilimci>(this.katilimciDao.getById(katilimci_id), "Id'ye göre data listelendi");
        }
    }
}
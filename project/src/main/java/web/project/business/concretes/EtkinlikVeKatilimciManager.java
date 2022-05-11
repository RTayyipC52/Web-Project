package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EtkinlikVeKatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
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
        return new SuccessResult("Kayıt Eklendi");
    }
    @Override
    public Result update(EtkinlikVeKatilimci etkinlikVeKatilimci){
        this.etkinlikVeKatilimciDao.save(etkinlikVeKatilimci);
        return new SuccessResult("Kayıt Güncellendi");
    }
    @Override
    public Result delete(int etkinlik_katilimci_id){
        this.etkinlikVeKatilimciDao.deleteById(etkinlik_katilimci_id);
        return new SuccessResult("Kayıt Silindi");
    }
    
    @Override
    public DataResult<EtkinlikVeKatilimci> getById(int etkinlik_katilimci_id) {
        if (this.etkinlikVeKatilimciDao.findById(etkinlik_katilimci_id).isEmpty()){
            return new ErrorDataResult<EtkinlikVeKatilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<EtkinlikVeKatilimci>(this.etkinlikVeKatilimciDao.getById(etkinlik_katilimci_id), "Id'ye göre data listelendi");
        }
    }
}
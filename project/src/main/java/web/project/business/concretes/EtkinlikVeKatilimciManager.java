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
    public Result delete(int etkinlikKatilimciId){
        this.etkinlikVeKatilimciDao.deleteById(etkinlikKatilimciId);
        return new SuccessResult("Kayıt Silindi");
    }
    
    @Override
    public DataResult<EtkinlikVeKatilimci> getById(int etkinlikKatilimciId) {
        if (this.etkinlikVeKatilimciDao.findById(etkinlikKatilimciId).isEmpty()){
            return new ErrorDataResult<EtkinlikVeKatilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<EtkinlikVeKatilimci>(this.etkinlikVeKatilimciDao.getById(etkinlikKatilimciId), "Id'ye göre data listelendi");
        }
    }

	@Override
	public DataResult<EtkinlikVeKatilimci> getByKatilimci_KatilimciId(int katilimciId) {
		if (this.etkinlikVeKatilimciDao.findById(katilimciId).isEmpty()){
            return new ErrorDataResult<EtkinlikVeKatilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<EtkinlikVeKatilimci>(this.etkinlikVeKatilimciDao.getByKatilimci_KatilimciId(katilimciId), "KatılımcıId'ye göre data listelendi");
        }
	}

	@Override
	public DataResult<EtkinlikVeKatilimci> getByEtkinlik_EtkinlikId(int etkinlikId) {
		if (this.etkinlikVeKatilimciDao.findById(etkinlikId).isEmpty()){
            return new ErrorDataResult<EtkinlikVeKatilimci>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<EtkinlikVeKatilimci>(this.etkinlikVeKatilimciDao.getByEtkinlik_EtkinlikId(etkinlikId), "EtkinlikId'ye göre data listelendi");
        }
	}
}
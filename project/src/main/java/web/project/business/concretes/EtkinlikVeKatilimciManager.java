package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EtkinlikVeKatilimciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.ErrorResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikVeKatilimciDao;
import web.project.entities.concretes.EtkinlikVeKatilimci;

import java.time.LocalDate;
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
    	if(this.etkinlikVeKatilimciDao.getByEtkinlik_Tarih(etkinlikVeKatilimci.getEtkinlik().getTarih()).isEmpty()) {	
	    	this.etkinlikVeKatilimciDao.save(etkinlikVeKatilimci);
	        return new SuccessResult("Kayıt Eklendi");
	    }else {
			return new ErrorResult("Bu tarihte başka bir etkinliğe katılacaksınız");
		}
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
	public DataResult<List<EtkinlikVeKatilimci>> getByKatilimci_KatilimciId(int katilimciId) {
		if (this.etkinlikVeKatilimciDao.getByKatilimci_KatilimciId(katilimciId).isEmpty()){
            return new ErrorDataResult<List<EtkinlikVeKatilimci>>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<List<EtkinlikVeKatilimci>>(this.etkinlikVeKatilimciDao.getByKatilimci_KatilimciId(katilimciId), "KatılımcıId'ye göre data listelendi");
        }
	}

	@Override
	public DataResult<List<EtkinlikVeKatilimci>> getByEtkinlik_EtkinlikId(int etkinlikId) {
		if (this.etkinlikVeKatilimciDao.getByEtkinlik_EtkinlikId(etkinlikId).isEmpty()){
            return new ErrorDataResult<List<EtkinlikVeKatilimci>>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<List<EtkinlikVeKatilimci>>(this.etkinlikVeKatilimciDao.getByEtkinlik_EtkinlikId(etkinlikId), "EtkinlikId'ye göre data listelendi");
        }
	}

	@Override
	public DataResult<List<EtkinlikVeKatilimci>> getByKatilimci_User_UserId(int userId) {
		if (this.etkinlikVeKatilimciDao.getByKatilimci_User_UserId(userId).isEmpty()){
            return new ErrorDataResult<List<EtkinlikVeKatilimci>>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<List<EtkinlikVeKatilimci>>(this.etkinlikVeKatilimciDao.getByKatilimci_User_UserId(userId), "UserId'ye göre data listelendi");
        }
	}

	@Override
	public DataResult<List<EtkinlikVeKatilimci>> getByEtkinlik_Tarih(LocalDate tarih) {
		return new SuccessDataResult<List<EtkinlikVeKatilimci>>(this.etkinlikVeKatilimciDao.getByEtkinlik_Tarih(tarih), "Tarihe göre data listelendi");
	}
}
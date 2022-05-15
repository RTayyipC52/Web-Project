package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.dataAccess.abstracts.EtkinlikVeKonusmaciDao;
import web.project.entities.concretes.EtkinlikVeKonusmaci;
import web.project.business.abstracts.EtkinlikVeKonusmaciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;

import java.util.List;

@Service
public class EtkinlikVeKonusmaciManager implements EtkinlikVeKonusmaciService {

	private EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao;

	@Autowired
	public EtkinlikVeKonusmaciManager(EtkinlikVeKonusmaciDao etkinlikVeKonusmaciDao) {
		this.etkinlikVeKonusmaciDao = etkinlikVeKonusmaciDao;
	}

	@Override
	public DataResult<List<EtkinlikVeKonusmaci>> getAll() {
		return new SuccessDataResult<List<EtkinlikVeKonusmaci>>(this.etkinlikVeKonusmaciDao.findAll(),
				"Data Listelendi");
	}

	@Override
	public Result add(EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
		this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
		return new SuccessResult("Kayıt Eklendi");
	}

	@Override
	public Result update(EtkinlikVeKonusmaci etkinlikVeKonusmaci) {
		this.etkinlikVeKonusmaciDao.save(etkinlikVeKonusmaci);
		return new SuccessResult("Kayıt Güncellendi");
	}

	@Override
	public Result delete(int etkinlikKonusmaciId) {
		this.etkinlikVeKonusmaciDao.deleteById(etkinlikKonusmaciId);
		return new SuccessResult("Kayıt Silindi");
	}

	@Override
	public DataResult<EtkinlikVeKonusmaci> getById(int etkinlikKonusmaciId) {
		if (this.etkinlikVeKonusmaciDao.findById(etkinlikKonusmaciId).isEmpty()) {
			return new ErrorDataResult<EtkinlikVeKonusmaci>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<EtkinlikVeKonusmaci>(
					this.etkinlikVeKonusmaciDao.getById(etkinlikKonusmaciId), "Id'ye göre data listelendi");
		}
	}

	@Override
	public DataResult<List<EtkinlikVeKonusmaci>> getByKonusmaci_KonusmaciId(int konusmaciId) {
		if (this.etkinlikVeKonusmaciDao.findById(konusmaciId).isEmpty()) {
			return new ErrorDataResult<List<EtkinlikVeKonusmaci>>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<List<EtkinlikVeKonusmaci>>(
					this.etkinlikVeKonusmaciDao.getByKonusmaci_KonusmaciId(konusmaciId),
					"KonusmacıId'ye göre data listelendi");
		}
	}

	@Override
	public DataResult<List<EtkinlikVeKonusmaci>> getByEtkinlik_EtkinlikId(int etkinlikId) {
		if (this.etkinlikVeKonusmaciDao.findById(etkinlikId).isEmpty()) {
			return new ErrorDataResult<List<EtkinlikVeKonusmaci>>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<List<EtkinlikVeKonusmaci>>(
					this.etkinlikVeKonusmaciDao.getByEtkinlik_EtkinlikId(etkinlikId),
					"EtkinlikId'ye göre data listelendi");
		}
	}

}

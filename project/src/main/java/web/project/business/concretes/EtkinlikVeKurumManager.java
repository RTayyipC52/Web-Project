package web.project.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EtkinlikVeKurumService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikVeKurumDao;
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
		return new SuccessDataResult<List<EtkinlikVeKurum>>(this.etkinlikVeKurumDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(EtkinlikVeKurum etkinlikVeKurum) {
		this.etkinlikVeKurumDao.save(etkinlikVeKurum);
		return new SuccessResult("Kayıt eklendi");
	}

	@Override
	public Result update(EtkinlikVeKurum etkinlikVeKurum) {
		this.etkinlikVeKurumDao.save(etkinlikVeKurum);
		return new SuccessResult("Kayıt güncellendi");
	}

	@Override
	public Result delete(int etkinlikKurumId) {
		this.etkinlikVeKurumDao.deleteById(etkinlikKurumId);
		return new SuccessResult("Kayıt silindi");
	}

	@Override
	public DataResult<EtkinlikVeKurum> getById(int etkinlikKurumId) {
		if (this.etkinlikVeKurumDao.findById(etkinlikKurumId).isEmpty()) {
			return new ErrorDataResult<EtkinlikVeKurum>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<EtkinlikVeKurum>(this.etkinlikVeKurumDao.getById(etkinlikKurumId),
					"Id'ye göre data listelendi");
		}
	}

	@Override
	public DataResult<List<EtkinlikVeKurum>> getByKurum_KurumId(int kurumId) {
		if (this.etkinlikVeKurumDao.getByKurum_KurumId(kurumId).isEmpty()) {
			return new ErrorDataResult<List<EtkinlikVeKurum>>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<List<EtkinlikVeKurum>>(this.etkinlikVeKurumDao.getByKurum_KurumId(kurumId),
					"KurumId'ye göre data listelendi");
		}
	}

	@Override
	public DataResult<List<EtkinlikVeKurum>> getByEtkinlik_EtkinlikId(int etkinlikId) {
		if (this.etkinlikVeKurumDao.getByEtkinlik_EtkinlikId(etkinlikId).isEmpty()) {
			return new ErrorDataResult<List<EtkinlikVeKurum>>("Bu Id'ye ait bir kayıt yoktur");
		} else {
			return new SuccessDataResult<List<EtkinlikVeKurum>>(
					this.etkinlikVeKurumDao.getByEtkinlik_EtkinlikId(etkinlikId),
					"EtkinlikId'ye göre data listelendi");
		}
	}

}

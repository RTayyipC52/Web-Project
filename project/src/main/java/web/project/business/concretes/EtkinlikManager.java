package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EtkinlikService;
import web.project.business.abstracts.EtkinlikVeKurumService;
import web.project.business.abstracts.KurumService;
import web.project.business.abstracts.SertifikaImageService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EtkinlikDao;
import web.project.dataAccess.abstracts.EtkinlikVeKurumDao;
import web.project.dataAccess.abstracts.SertifikaImageDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.EtkinlikVeKurum;
import web.project.entities.dtos.AddEtkinlikDto;

import java.util.List;

@Service
public class EtkinlikManager implements EtkinlikService {
	private EtkinlikDao etkinlikDao;
	private SertifikaImageService sertifikaImageService;
	private EtkinlikVeKurumDao etkinlikVeKurumDao;
	private KurumService kurumService;

	@Autowired
	public EtkinlikManager(EtkinlikDao etkinlikDao,SertifikaImageService sertifikaImageService,
	SertifikaImageDao sertifikaImageDao,KurumService kurumService,
	EtkinlikVeKurumService etkinlikVeKurumService,
	EtkinlikVeKurumDao etkinlikVeKurumDao) {
		this.etkinlikDao = etkinlikDao;
		this.etkinlikVeKurumDao = etkinlikVeKurumDao;
		this.sertifikaImageService = sertifikaImageService;
		this.kurumService = kurumService;
	}

	@Override
	public DataResult<List<Etkinlik>> getAll() {
		return new SuccessDataResult<List<Etkinlik>>(this.etkinlikDao.findAll(), "Etkinlikler listelendi");
	}

	@Override
	public Result add(Etkinlik etkinlik) {
		if (this.etkinlikDao.getBySertifikaImage_SertifikaImageId(etkinlik.getSertifikaImage().getSertifikaImageId()).isEmpty()) {
			this.etkinlikDao.save(etkinlik);
			return new SuccessResult("Etkinlik eklendi");
		} else {
			return new ErrorDataResult<Etkinlik>("Bu SertifikaId'ye ait bir kay??t vard??r. Ba??ka sertifika se??iniz");
		}
	}

	@Override
	public Result update(Etkinlik etkinlik) {
		Etkinlik e = getById(etkinlik.getEtkinlikId()).getData();
		
		etkinlik.setEtkinlikAd((etkinlik.getEtkinlikAd() == null || etkinlik.getEtkinlikAd() == ""
				? e.getEtkinlikAd()
				: etkinlik.getEtkinlikAd()));
		etkinlik.setEtkinlikAciklama((etkinlik.getEtkinlikAciklama() == null || etkinlik.getEtkinlikAciklama() == ""
				? e.getEtkinlikAciklama()
				: etkinlik.getEtkinlikAciklama()));
		etkinlik.setTarih((etkinlik.getTarih() == null
				? e.getTarih()
				: etkinlik.getTarih()));
		etkinlik.setYer((etkinlik.getYer() == null || etkinlik.getYer() == ""
				? e.getYer()
				: etkinlik.getYer()));
		etkinlik.setSertifikaImage((etkinlik.getSertifikaImage().getSertifikaImageId() == 0
				? e.getSertifikaImage()
				: etkinlik.getSertifikaImage()));
		
		this.etkinlikDao.save(etkinlik);
		return new SuccessResult("Etkinlik g??ncellendi");
	}

	@Override
	public Result delete(int etkinlikId) {
		this.etkinlikDao.deleteById(etkinlikId);
		return new SuccessResult("Etkinlik silindi");
	}

	@Override
	public DataResult<Etkinlik> getById(int etkinlikId) {
		if (this.etkinlikDao.findById(etkinlikId).isEmpty()) {
			return new ErrorDataResult<Etkinlik>("Bu Id'ye ait bir kay??t yoktur");
		} else {
			return new SuccessDataResult<Etkinlik>(this.etkinlikDao.getById(etkinlikId), "Id'ye g??re data listelendi");
		}
	}

	@Override
	public DataResult<List<Etkinlik>> getBySertifikaImage_SertifikaImageId(int sertifikaImageId) {
		if (this.etkinlikDao.getBySertifikaImage_SertifikaImageId(sertifikaImageId).isEmpty()) {
			return new ErrorDataResult<List<Etkinlik>>("Bu Id'ye ait bir kay??t yoktur");
		} else {
			return new SuccessDataResult<List<Etkinlik>>(this.etkinlikDao.getBySertifikaImage_SertifikaImageId(sertifikaImageId),
					"sertifikaIdye g??re data listelendi");
		}
	}

	@Override
	public Result add(AddEtkinlikDto addEtkinlikDto) {
		if (this.etkinlikDao.getBySertifikaImage_SertifikaImageId(addEtkinlikDto.getSertifikaImageId()).isEmpty()) {
			Etkinlik etkinlik = new Etkinlik();
			etkinlik.setEtkinlikAd(addEtkinlikDto.getEtkinlikAd());
			etkinlik.setEtkinlikAciklama(addEtkinlikDto.getEtkinlikAciklama());
			etkinlik.setTarih(addEtkinlikDto.getTarih());
			etkinlik.setYer(addEtkinlikDto.getYer());
			etkinlik.setSertifikaImage(sertifikaImageService.getById(addEtkinlikDto.getSertifikaImageId()).getData());
			
			EtkinlikVeKurum etkinlikVeKurum = new EtkinlikVeKurum();
			etkinlikVeKurum.setEtkinlik(etkinlik);
			etkinlikVeKurum.setKurum(kurumService.getById(addEtkinlikDto.getKurumId()).getData());
			
			this.etkinlikDao.save(etkinlik);
			this.etkinlikVeKurumDao.save(etkinlikVeKurum);
			return new SuccessResult("Etkinlik eklendi");
		} else {
			return new ErrorDataResult<Etkinlik>("Bu SertifikaId'ye ait bir kay??t vard??r. Ba??ka sertifika se??iniz");
		}
	}
}
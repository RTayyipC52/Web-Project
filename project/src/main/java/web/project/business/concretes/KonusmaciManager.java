package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.KonusmaciService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KonusmaciDao;
import web.project.entities.concretes.Konusmaci;

import java.util.List;

    @Service
    public class KonusmaciManager implements KonusmaciService {
        private KonusmaciDao konusmaciDao;

        @Autowired
        public KonusmaciManager(KonusmaciDao konusmaciDao) {
            this.konusmaciDao = konusmaciDao;
        }

        @Override
        public DataResult<List<Konusmaci>> getAll() {
            return new SuccessDataResult<List<Konusmaci>>
                    (this.konusmaciDao.findAll(),"Konusmacilar listelendi");
        }

        @Override
        public Result add(Konusmaci konusmaci) {
            this.konusmaciDao.save(konusmaci);
            return new SuccessResult("Konusmaci eklendi");
        }

        @Override
        public Result update(Konusmaci konusmaci) {
            this.konusmaciDao.save(konusmaci);
            return new SuccessResult("Konusmaci güncellendi");
        }
        @Override
        public Result delete(int konusmaci_id){
            this.konusmaciDao.deleteById(konusmaci_id);
            return new SuccessResult("Konusmaci silindi");
        }

        @Override
        public DataResult<Konusmaci> getById(int konusmaci_id) {
            if (this.konusmaciDao.findById(konusmaci_id).isEmpty()){
                return new ErrorDataResult<Konusmaci>("Bu Id'ye ait bir kayıt yoktur");
            }else {
                return new SuccessDataResult<Konusmaci>(this.konusmaciDao.getById(konusmaci_id), "Id'ye göre data listelendi");
            }
        }
    }
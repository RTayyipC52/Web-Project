package web.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.KatilimciDao;
import web.project.dataAccess.abstracts.KonusmaciDao;
import web.project.entities.concretes.Etkinlik;
import web.project.entities.concretes.Katilimci;
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
            return new SuccessDataResult<List<Etkinlik>>
                    (this.konusmaciDao.findAll(),"konusmacilar listelendi");
        }

        @Override
        public Result add(Konusmaci konusmaci) {
            this.konusmaciDao.save(konusmaci);
            return new SuccessResult("konusmaci eklendi");
        }

        @Override
        public Result update(Konusmaci konusmaci) {
            this.konusmaciDao.save(konusmaci);
            return new SuccessResult("konusmaci güncellendi");
        }
        @Override
        public Result delete(int ){
            this.konusmaciDao.deleteById();
            return new SuccessResult("konusmaci silindi");
        }
















    }

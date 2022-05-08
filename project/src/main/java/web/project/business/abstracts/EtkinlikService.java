package web.project.business.abstracts;

import web.project.core.utilities.results.DataResult;
import web.project.core.utilities.results.Result;
import web.project.entities.concretes.AnimalBreed;
import web.project.entities.concretes.Etkinlik;

import java.awt.image.RescaleOp;
import java.util.List;

public interface EtkinlikService extends BaseEntityService<Etkinlik>{
    DataResult<Etkinlik> getByBreedId(int breedId);
    DataResult<List<Etkinlik>> getByAnimalType_TypeId(int typeId);
    Result delete(int breedId);
}

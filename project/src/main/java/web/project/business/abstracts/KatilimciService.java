package web.project.business.abstracts;

import web.project.entities.concretes.Katilimci;
import web.project.entities.dtos.KatilimciRegisterDto;

import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface KatilimciService extends BaseEntityService<Katilimci>{
	DataResult<Katilimci> getById(int katilimciId);
	Result delete(int katilimciId);
	DataResult<List<Katilimci>> getByUser_UserId(int userId);
	Result add(KatilimciRegisterDto katilimciRegisterDto);
}

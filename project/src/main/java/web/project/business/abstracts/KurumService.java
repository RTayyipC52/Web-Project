package web.project.business.abstracts;

import web.project.entities.concretes.Kurum;
import web.project.entities.dtos.KurumRegisterDto;
import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface KurumService extends BaseEntityService<Kurum>{
	DataResult<Kurum> getById(int kurumId);
	Result delete(int kurumId);
	DataResult<Kurum> getByUser_UserId(int userId);
	Result add(KurumRegisterDto kurumRegisterDto);
}

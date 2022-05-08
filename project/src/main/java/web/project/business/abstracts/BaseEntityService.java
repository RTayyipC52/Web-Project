package web.project.business.abstracts;
import web.project.core.utilities.results.DataResult;
import web.project.core.utilities.results.Result;

import web.project.core.results.DataResult;

public interface BaseEntityService<T> {
    DataResult<List<T>> getAll();
    Result add(T entity);
    Result update(T entity);
}

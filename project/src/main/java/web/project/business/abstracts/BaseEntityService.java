package web.project.business.abstracts;
import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;

public interface BaseEntityService<T> {
    DataResult<List<T>> getAll();
    Result add(T entity);
    Result update(T entity);
}

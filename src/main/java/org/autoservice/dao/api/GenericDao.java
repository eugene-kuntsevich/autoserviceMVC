package org.autoservice.dao.api;

import java.util.List;

public interface GenericDao<T> {
    T get(long id);
    void delete(T entity);
    void saveOrUpdate(T entity);
    List<T> list();
}

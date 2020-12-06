package org.autoservice.service.api;

import org.autoservice.service.exception.ValidatorException;

import java.util.List;

public interface GenericService<T, Dto> {
    Dto get(long id);
    void delete(long id);
    void saveOrUpdate(Dto entity) throws ValidatorException;
    List<Dto> list();
}

package org.autoservice.service.api;

import java.util.List;

public interface GenericService<T, Dto> {
    Dto get(long id);
    void delete(long id);
    void saveOrUpdate(Dto entity);
    List<Dto> list();
}

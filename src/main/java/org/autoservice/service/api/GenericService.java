package org.autoservice.service.api;

import java.util.List;

public interface GenericService<T, Dto> {
    Dto get(long id);
    void delete(long id);
    void save(Dto entity);
    void update(Dto entity);
    List<Dto> list();
}

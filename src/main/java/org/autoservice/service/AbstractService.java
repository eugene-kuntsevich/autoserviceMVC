package org.autoservice.service;

import org.autoservice.dao.api.GenericDao;
import org.autoservice.service.api.GenericService;
import org.autoservice.service.dtoconverter.AbstractDtoConverter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractService<T, Dto> implements GenericService<T, Dto> {
    private GenericDao<T> genericDao;
    private AbstractDtoConverter<T, Dto> abstractDtoConverter;

    public AbstractService(GenericDao<T> genericDao, AbstractDtoConverter<T, Dto> abstractDtoConverter) {
        this.genericDao = genericDao;
        this.abstractDtoConverter = abstractDtoConverter;
    }

    @Override
    public void delete(long id) {
        T entity = genericDao.get(id);
        genericDao.delete(entity);
    }

    @Override
    public void saveOrUpdate(Dto dto) {
        T entity = (T) abstractDtoConverter.convertToEntity(dto);
        genericDao.saveOrUpdate(entity);
    }

    @Override
    public List<Dto> list() {
        return abstractDtoConverter.convertListToDto(genericDao.list());
    }

    @Override
    public Dto get(long id) {
        return abstractDtoConverter.convertToDto(genericDao.get(id));
    }
}

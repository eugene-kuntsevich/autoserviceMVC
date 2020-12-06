package org.autoservice.service.dtoconverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDtoConverter<T, Dto> {

    @Autowired
    private ModelMapper modelMapper;

    private Class<T> tClass;
    private Class<Dto> dtoClass;

    public AbstractDtoConverter(Class<T> tClass, Class<Dto> dtoClass) {
        this.tClass = tClass;
        this.dtoClass = dtoClass;
    }

    public T convertToEntity(Dto dto) {
        return modelMapper.map(dto, tClass);
    }

    public Dto convertToDto(T entity) {
        return modelMapper.map(entity, dtoClass);
    }

    public List<Dto> convertListToDto(List<T> tList) {
        return tList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}

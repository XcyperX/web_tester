package com.example.webcontent.mapper;

import com.example.webcontent.model.Answer;

import java.util.List;

public interface BaseMapperService<T, E> {
    T toEntity(E dto);
    E toDto(T entity);

    List<T> toEntities(List<E> dto);
    List<E> toDtos(List<T> entity);
}

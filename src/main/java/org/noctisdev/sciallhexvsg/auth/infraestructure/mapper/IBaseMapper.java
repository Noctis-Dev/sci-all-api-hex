package org.noctisdev.sciallhexvsg.auth.infraestructure.mapper;

public interface IBaseMapper<D, E> {
    D toDomain(E entity);
    E toEntity(D model);
}

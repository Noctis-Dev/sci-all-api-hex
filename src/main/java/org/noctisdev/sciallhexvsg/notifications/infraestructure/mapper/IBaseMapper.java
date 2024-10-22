package org.noctisdev.sciallhexvsg.notifications.infraestructure.mapper;

public interface IBaseMapper<D, E> {
    D toDomain(E entity);
    E toEntity(D domain);
}

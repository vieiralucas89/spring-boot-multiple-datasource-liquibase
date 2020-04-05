package com.springbootmultipledatasourceliquibase.domain.utils;

import com.springbootmultipledatasourceliquibase.domain.intranet.entidade.dtos.DTOEntity;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DtoUtils {

    /**
     * <p>Note: Converte um DTO comum em um Objeto tipado</p>
     *
     * @param obj    tipo do objeto que será convertido
     * @param mapper DDTO
     * @return objeto mapeado com o tipo <code><D> </code>.
     */
    public DTOEntity convertToDto(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    /**
     * <p>Note: Converte um objeto tipado em um DTO</p>
     *
     * @param obj    tipo do objeto que será convertido
     * @param mapper Classe
     * @return objeto mapeado com o tipo <code><D> </code>.
     */
    public Object convertToEntity(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    /**
     * <p>Note: Converte uma lista comum de objetos para uma lista do DTO
     * que será passado</p>
     *
     * @param entityList lista de entidades que precisam ser mapeadas
     * @param mapper     DTO
     * @return lista de objetos mapeados com o tipo <code><D> </code>.
     */
    public List<DTOEntity> convertToListDTO(final Collection<Object> entityList, DTOEntity mapper) {
        return entityList.stream()
                .map(entity -> convertToDto(entity, mapper))
                .collect(Collectors.toList());
    }

    /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return new ModelMapper().map(entity, outClass);
    }

}

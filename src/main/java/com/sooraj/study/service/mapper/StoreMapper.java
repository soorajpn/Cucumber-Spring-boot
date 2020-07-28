package com.sooraj.study.service.mapper;

import com.sooraj.study.domain.*;
import com.sooraj.study.service.dto.StoreDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Store} and its DTO {@link StoreDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StoreMapper extends EntityMapper<StoreDTO, Store> {


    @Mapping(target = "stocks", ignore = true)
    @Mapping(target = "removeStock", ignore = true)
    Store toEntity(StoreDTO storeDTO);

    default Store fromId(Long id) {
        if (id == null) {
            return null;
        }
        Store store = new Store();
        store.setId(id);
        return store;
    }
}

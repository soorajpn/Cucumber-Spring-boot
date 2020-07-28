package com.sooraj.study.service.mapper;

import com.sooraj.study.domain.*;
import com.sooraj.study.service.dto.StockDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Stock} and its DTO {@link StockDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, StoreMapper.class})
public interface StockMapper extends EntityMapper<StockDTO, Stock> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "store.id", target = "storeId")
    StockDTO toDto(Stock stock);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "storeId", target = "store")
    Stock toEntity(StockDTO stockDTO);

    default Stock fromId(Long id) {
        if (id == null) {
            return null;
        }
        Stock stock = new Stock();
        stock.setId(id);
        return stock;
    }
}

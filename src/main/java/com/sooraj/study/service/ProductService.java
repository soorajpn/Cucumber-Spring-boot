package com.sooraj.study.service;

import com.sooraj.study.service.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.sooraj.study.domain.Product}.
 */
public interface ProductService {

    /**
     * Save a product.
     *
     * @param productDTO the entity to save.
     * @return the persisted entity.
     */
    ProductDTO save(ProductDTO productDTO);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<ProductDTO> findAll();


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductDTO> findOne(Long id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

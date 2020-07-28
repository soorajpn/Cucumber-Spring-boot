package com.sooraj.study.web.rest;

import com.sooraj.study.service.StoreService;
import com.sooraj.study.web.rest.errors.BadRequestAlertException;
import com.sooraj.study.service.dto.StoreDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.sooraj.study.domain.Store}.
 */
@RestController
@RequestMapping("/api")
public class StoreResource {

    private final Logger log = LoggerFactory.getLogger(StoreResource.class);

    private static final String ENTITY_NAME = "store4Store";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreService storeService;

    public StoreResource(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * {@code POST  /stores} : Create a new store.
     *
     * @param storeDTO the storeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeDTO, or with status {@code 400 (Bad Request)} if the store has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/stores")
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO) throws URISyntaxException {
        log.debug("REST request to save Store : {}", storeDTO);
        if (storeDTO.getId() != null) {
            throw new BadRequestAlertException("A new store cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StoreDTO result = storeService.save(storeDTO);
        return ResponseEntity.created(new URI("/api/stores/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /stores} : Updates an existing store.
     *
     * @param storeDTO the storeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeDTO,
     * or with status {@code 400 (Bad Request)} if the storeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/stores")
    public ResponseEntity<StoreDTO> updateStore(@RequestBody StoreDTO storeDTO) throws URISyntaxException {
        log.debug("REST request to update Store : {}", storeDTO);
        if (storeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        StoreDTO result = storeService.save(storeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, storeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /stores} : get all the stores.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stores in body.
     */
    @GetMapping("/stores")
    public List<StoreDTO> getAllStores() {
        log.debug("REST request to get all Stores");
        return storeService.findAll();
    }

    /**
     * {@code GET  /stores/:id} : get the "id" store.
     *
     * @param id the id of the storeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/stores/{id}")
    public ResponseEntity<StoreDTO> getStore(@PathVariable Long id) {
        log.debug("REST request to get Store : {}", id);
        Optional<StoreDTO> storeDTO = storeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(storeDTO);
    }

    /**
     * {@code DELETE  /stores/:id} : delete the "id" store.
     *
     * @param id the id of the storeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        log.debug("REST request to delete Store : {}", id);
        storeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

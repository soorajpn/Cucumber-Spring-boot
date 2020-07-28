package com.sooraj.study.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class StoreMapperTest {

    private StoreMapper storeMapper;

    @BeforeEach
    public void setUp() {
        storeMapper = new StoreMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(storeMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(storeMapper.fromId(null)).isNull();
    }
}

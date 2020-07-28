package com.sooraj.study.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.sooraj.study.web.rest.TestUtil;

public class StoreDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(StoreDTO.class);
        StoreDTO storeDTO1 = new StoreDTO();
        storeDTO1.setId(1L);
        StoreDTO storeDTO2 = new StoreDTO();
        assertThat(storeDTO1).isNotEqualTo(storeDTO2);
        storeDTO2.setId(storeDTO1.getId());
        assertThat(storeDTO1).isEqualTo(storeDTO2);
        storeDTO2.setId(2L);
        assertThat(storeDTO1).isNotEqualTo(storeDTO2);
        storeDTO1.setId(null);
        assertThat(storeDTO1).isNotEqualTo(storeDTO2);
    }
}

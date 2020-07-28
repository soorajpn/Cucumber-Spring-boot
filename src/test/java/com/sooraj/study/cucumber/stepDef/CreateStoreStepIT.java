package com.sooraj.study.cucumber.stepDef;

import com.sooraj.study.domain.Store;
import com.sooraj.study.repository.StoreRepository;
import com.sooraj.study.service.StoreService;
import com.sooraj.study.service.mapper.StoreMapper;
import com.sooraj.study.web.rest.StoreResource;
import com.sooraj.study.web.rest.TestUtil;
import com.sooraj.study.web.rest.errors.ExceptionTranslator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.sooraj.study.web.rest.TestUtil.createFormattingConversionService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.study.sooraj.cucuber"})
public class CreateStoreStepIT {


    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private StoreService storeService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restStoreMockMvc;

    private Store store;


    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StoreResource storeResource = new StoreResource(storeService);
        this.restStoreMockMvc = MockMvcBuilders.standaloneSetup(storeResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    @Given("configure Store controll")
    public void configure_Store_controll() {

        setup();






    }

    @When("we givan store to create")
    public void we_givan_store_to_create(io.cucumber.datatable.DataTable dataTable) throws IOException {

        List<Map<String,String>> coloums=dataTable.asMaps();
        store=new Store();
        store.setName(coloums.get(0).get("name"));
        store.setDescription(coloums.get(0).get("description"));
        store.setPhoneNumber(coloums.get(0).get("phone"));

        try {
            restStoreMockMvc.perform(post("/api/stores")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(storeMapper.toDto(store))))
                .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Then("find all and check for")
    public void find_all_and_check_for(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        List<Store> stores= storeRepository.findAll();

        Assert.assertTrue(stores.get(0).getName().equals(store.getName()));


    }


}

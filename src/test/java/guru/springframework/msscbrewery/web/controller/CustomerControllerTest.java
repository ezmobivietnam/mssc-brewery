package guru.springframework.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ezmobivietnam on 2020-12-29.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest extends TestCase {

    private final String BASE_URL = "/api/v1/customer";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @Autowired
    ObjectMapper objectMapper;

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    @Test
    public void testGetCustomer() throws Exception {
        // given
        UUID uuid = UUID.randomUUID();
        CustomerDto customerDto = CustomerDto.builder().id(uuid).name("Duong Thanh Binh").build();
        given(customerService.getCustomerById(uuid)).willReturn(customerDto);
        //when
        mockMvc.perform(get(BASE_URL + "/" + uuid.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(uuid.toString())));
    }

    @Test
    public void addCustomer() throws Exception {
        UUID uuid = UUID.randomUUID();
        CustomerDto customerDto = CustomerDto.builder().id(uuid).name("Duong Thanh Binh").build();
        given(customerService.addCustomer(customerDto)).willReturn(customerDto);
        //when
        mockMvc.perform(post(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", equalTo(uuid.toString())));
    }

    @Test
    public void updateCustomer() throws Exception {
        //given
        UUID uuid = UUID.randomUUID();
        CustomerDto customerDto = CustomerDto.builder().id(uuid).name("Duong Thanh Binh").build();
        given(customerService.updateCustomer(uuid, customerDto)).willReturn(customerDto);
        //when
        mockMvc.perform(put(BASE_URL + "/" + customerDto.getId().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(customerDto.getId().toString())));
    }

    @Test
    public void deleteCustomerById() throws Exception {
        //given
        UUID uuid = UUID.randomUUID();
        //when
        mockMvc.perform(delete(BASE_URL + "/" + uuid.toString())).andExpect(status().isNoContent());
    }
}
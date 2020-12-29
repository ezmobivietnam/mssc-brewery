package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

/**
 * Created by ezmobivietnam on 2020-12-28.
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
}

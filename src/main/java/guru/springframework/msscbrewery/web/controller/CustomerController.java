package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by jt on 2019-04-21.
 */

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable("customerId")  UUID customerId){

        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerDto);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        return customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable UUID customerId) {
        customerService.deleteCustomerById(customerId);
    }
}

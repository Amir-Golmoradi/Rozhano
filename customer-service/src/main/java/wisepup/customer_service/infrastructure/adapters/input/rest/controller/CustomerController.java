package wisepup.customer_service.infrastructure.adapters.input.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wisepup.customer_service.application.services.CustomerServiceImpl;
import wisepup.customer_service.infrastructure.dto.CustomerDTO;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerServiceImpl customerUseCase;

    @Autowired
    public CustomerController(CustomerServiceImpl customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public void createdCustomer(@RequestBody CustomerDTO customerDTO) {
        customerUseCase.createCustomer(customerDTO);
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerUseCase.getCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") int id) {
        return customerUseCase.getCustomerById(id);
    }

}

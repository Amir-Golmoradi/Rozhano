package wisepup.customer_service.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.port.outgoing.CustomerCreatedRequest;
import wisepup.customer_service.application.service.incoming.CustomerService;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.infrastructure.exception.CustomerNotFoundException;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") UUID id) {
        return service.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with Id" + id + " not found"));
    }

    @GetMapping("/phoneNumber/{phoneNumber}")
    public CustomerDTO getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return service.findCustomerByPhoneNumber(new PhoneNumber(phoneNumber))
                .orElseThrow(() -> new CustomerNotFoundException("Customer with phoneNumber" + phoneNumber + " not found"));
    }


    @PostMapping
    public void createCustomer(@RequestBody CustomerCreatedRequest request) {
        service.insertCustomer(request);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id) {
        service.deleteCustomerById(id);
    }
}


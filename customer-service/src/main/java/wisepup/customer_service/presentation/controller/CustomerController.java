package wisepup.customer_service.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.mapper.CustomerDTOMapper;
import wisepup.customer_service.application.port.outgoing.CustomerCreatedRequest;
import wisepup.customer_service.application.service.outgoing.CustomerManagementService;
import wisepup.customer_service.infrastructure.exception.CustomerNotFoundException;
import wisepup.customer_service.infrastructure.mapper.CustomerMapper;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerManagementService service;
    private final CustomerMapper mapper;
    private final CustomerDTOMapper dtoMapper;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return service.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") UUID id) {
        return service.findCustomerById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with Id" + id + " not found"));
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


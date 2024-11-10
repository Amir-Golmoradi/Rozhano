package wisepup.customer_service.infrastructure.adapters.incoming.rest.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.request.CreatedCustomerRequest;
import wisepup.customer_service.application.ports.outgoing.CustomerManagementService;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.factories.CustomerBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CustomerController {
    private final CustomerManagementService customerUseCase;

    @PostMapping
    public ResponseEntity<Customer> createdCustomer(@Valid @RequestBody CreatedCustomerRequest customerRequest) {
        customerUseCase.registerNewCustomer(customerRequest);
        return ResponseEntity.ok(
                new CustomerBuilder()
                        .withFullName(customerRequest.getPersonalInfo().firstName(), customerRequest.getPersonalInfo().lastName())
                        .withPhoneNumber(customerRequest.getPersonalInfo().phoneNumber())
                        .withAddress(
                                customerRequest.getDeliveryAddress().city(),
                                customerRequest.getDeliveryAddress().street(),
                                customerRequest.getDeliveryAddress().alley(),
                                customerRequest.getDeliveryAddress().zipCode()
                        )
                        .build()
        );
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerUseCase.getCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") UUID id) {
        return customerUseCase.getCustomerById(id);
    }

}

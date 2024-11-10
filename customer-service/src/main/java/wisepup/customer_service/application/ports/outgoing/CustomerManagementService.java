package wisepup.customer_service.application.ports.outgoing;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.request.CreatedCustomerRequest;
import wisepup.customer_service.application.dto.request.UpdatedCustomerRequest;
import wisepup.customer_service.application.exceptions.CustomerNotFoundException;
import wisepup.customer_service.application.mapper.CustomerDTOMapper;
import wisepup.customer_service.application.ports.incoming.CustomerServicePort;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.factories.CustomerBuilder;
import wisepup.customer_service.domain.repository.ICustomerRepository;
import wisepup.customer_service.domain.valueObjects.Address;
import wisepup.customer_service.domain.valueObjects.FullName;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerManagementService implements CustomerServicePort {
    private final CustomerDTOMapper mapper;
    private final ICustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.getAllCustomers().stream().map(mapper).toList();
    }

    @Override
    public CustomerDTO registerNewCustomer(CreatedCustomerRequest request) {
        Customer customer = new CustomerBuilder().withFullName(request.getPersonalInfo().firstName(), request.getPersonalInfo().lastName()).withPhoneNumber(request.getPersonalInfo().phoneNumber()).withAddress(request.getDeliveryAddress().city(), request.getDeliveryAddress().street(), request.getDeliveryAddress().alley(), request.getDeliveryAddress().zipCode()).build();
        return mapper.apply(customer);
    }


    @Override
    public CustomerDTO updateCustomer(UUID customerId, UpdatedCustomerRequest request) {
        // 1. Fetch existing customers.
        Customer existingCustomers = customerRepository.getCustomerById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));
        // 2. Update the customer details
        existingCustomers.updatePersonalInfo(FullName.of(request.getPersonalInfo().firstName(), request.getPersonalInfo().lastName()));
        existingCustomers.updateDeliveryAddress(Address.of(request.getDeliveryAddress().city(), request.getDeliveryAddress().street(), request.getDeliveryAddress().alley(), request.getDeliveryAddress().zipCode()));
        // 3. Save the updated customer
        customerRepository.save(existingCustomers);
        // 4. Return the updated CustomerDTO
        return mapper.apply(existingCustomers);
    }


    @Override
    public void deleteCustomer(UUID customerId) {
        Customer customer = customerRepository.getCustomerById(customerId).orElseThrow(() -> new IllegalArgumentException("Customer not found"));

    }

    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return customerRepository.getCustomerById(customerId).stream().map(mapper).toList().get(0);
    }
}

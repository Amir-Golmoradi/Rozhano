package wisepup.customer_service.application.service.outgoing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.mapper.CustomerDTOMapper;
import wisepup.customer_service.application.port.outgoing.CustomerCreatedRequest;
import wisepup.customer_service.application.service.incoming.CustomerService;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.Address;
import wisepup.customer_service.domain.model.value_object.FullName;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.domain.repository.CustomerDAO;
import wisepup.customer_service.infrastructure.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerManagementService implements CustomerService {
    private final CustomerDTOMapper mapper;
    private final CustomerDAO customerDAO;

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerDAO.findAllCustomers().stream().map(mapper).toList();
    }

    @Override
    public Optional<CustomerDTO> findCustomerById(UUID customerId) {
        return Optional.ofNullable(customerDAO.findCustomerById(customerId).map(mapper)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer with id " + customerId + " not found"))
        );

    }

    @Override
    public Optional<CustomerDTO> findCustomerByPhoneNumber(PhoneNumber phoneNumber) {
        return Optional.ofNullable(customerDAO.findCustomerByPhoneNumber(phoneNumber)
                .map(mapper)
                .orElseThrow(
                        () ->
                                new CustomerNotFoundException("Customer with PhoneNumber " + phoneNumber.getPhoneNumber() + " Not Found")
                )
        );
    }

    @Override
    public void insertCustomer(CustomerCreatedRequest request) {

        var newCustomer = new Customer(
                new FullName(request.firstName(), request.lastName()),
                new PhoneNumber(request.phoneNumber()),
                Address.of(
                        request.address().getCity(),
                        request.address().getStreet(),
                        request.address().getAlley(),
                        request.address().getZipCode()
                )
        );
        customerDAO.saveCustomer(newCustomer);
    }

    @Override
    public boolean existsCustomerById(UUID customerId) {
        return customerDAO.existsCustomerById(customerId);
    }

    @Override
    public boolean existsCustomerByPhoneNumber(PhoneNumber phoneNumber) {
        return customerDAO.existsCustomerByPhoneNumber(phoneNumber);
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        customerDAO.deleteCustomerById(customerId);
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customer) {
        Customer existingCustomer = customerDAO.findCustomerById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with ID " + customerId + " not found"));

        // Create a new Address instance with validation
        Address newAddress = Address.of(
                customer.address().getCity(), customer.address().getStreet(),
                customer.address().getAlley(), customer.address().getZipCode()
        );

        // Create a new Customer instance with updated address (if Customer is immutable)
        Customer updatedCustomer = new Customer(
                existingCustomer.getFullName(),
                existingCustomer.getPhoneNumber(),
                newAddress
        );

        // Save the updated customer
        customerDAO.saveCustomer(updatedCustomer);
    }

    @Override
    public void save(Customer customer) {
        customerDAO.saveCustomer(customer);
    }
}

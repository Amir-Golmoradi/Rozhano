package wisepup.customer_service.application.service.incoming;

import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.port.outgoing.CustomerCreatedRequest;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> findAllCustomers();

    Optional<CustomerDTO> findCustomerById(UUID customerId);

    Optional<CustomerDTO> findCustomerByPhoneNumber(PhoneNumber phoneNumber);

    void insertCustomer(CustomerCreatedRequest request);

    boolean existsCustomerById(UUID customerId);

    boolean existsCustomerByPhoneNumber(PhoneNumber phoneNumber);

    void deleteCustomerById(UUID customerId);

    void updateCustomer(UUID customerId, CustomerDTO customer);

    void save(Customer customer);
}

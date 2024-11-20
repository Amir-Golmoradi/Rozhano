package wisepup.customer_service.domain.repository;

import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDAO {
    List<Customer> getAllCustomers();

    Optional<Customer> findCustomerById(UUID customerId);

    Optional<Customer> findCustomerByPhoneNumber(PhoneNumber phoneNumber);

    void insertCustomer(Customer customer);

    boolean existsCustomerById(UUID customerId);

    boolean existsCustomerByPhoneNumber(PhoneNumber phoneNumber);

    void deleteCustomerById(UUID customerId);

    void updateCustomer(UUID customerId, Customer customer);

    void saveCustomer(Customer customer);
}

package wisepup.customer_service.domain.repository;

import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ICustomerRepository {
    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(UUID id);

    Optional<Customer> getCustomerByPhoneNumber(PhoneNumber phoneNumber);

    void save(Customer customerEntity);
}

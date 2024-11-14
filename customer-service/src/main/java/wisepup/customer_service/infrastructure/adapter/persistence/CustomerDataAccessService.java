package wisepup.customer_service.infrastructure.adapter.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.domain.repository.CustomerDAO;
import wisepup.customer_service.infrastructure.exception.CustomerNotFoundException;
import wisepup.customer_service.infrastructure.mapper.CustomerMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerDataAccessService implements CustomerDAO {
    private final CustomerDataJpaRepository jpaRepository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerDataAccessService(CustomerDataJpaRepository jpaRepository, CustomerMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }


    @Override
    public List<Customer> findAllCustomers() {
        return jpaRepository.findAll().stream().map(mapper).toList();
    }

    @Override
    public Optional<Customer> findCustomerById(UUID customerId) {
        return jpaRepository.findById(customerId).map(mapper);
    }

    @Override
    public Optional<Customer> findCustomerByPhoneNumber(PhoneNumber phoneNumber) {
        if (!jpaRepository.existsCustomerByPhoneNumber(phoneNumber.getPhoneNumber())) {
            throw new CustomerNotFoundException("Customer with this phone number does not exist");
        } else {
            return jpaRepository.findCustomerByPhoneNumber(phoneNumber.getPhoneNumber()).map(mapper);
        }
    }

    @Override
    public void insertCustomer(Customer customer) {
        var newCustomer = new Customer(
                customer.getFullName(),
                customer.getPhoneNumber(),
                customer.getAddress()
        );
        var customerData = mapper.toData(newCustomer);
        jpaRepository.save(customerData);
    }

    @Override
    public boolean existsCustomerById(UUID customerId) {
        return jpaRepository.existsCustomerById(customerId);
    }

    @Override
    public boolean existsCustomerByPhoneNumber(PhoneNumber phoneNumber) {
        return jpaRepository.existsCustomerByPhoneNumber(phoneNumber.getPhoneNumber());
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        jpaRepository.deleteById(customerId);
        jpaRepository.flush();
    }

    @Override
    public void updateCustomer(UUID customerId, Customer customer) {

    }

    @Override
    public void saveCustomer(Customer customer) {
        jpaRepository.save(mapper.toData(customer));
    }
}

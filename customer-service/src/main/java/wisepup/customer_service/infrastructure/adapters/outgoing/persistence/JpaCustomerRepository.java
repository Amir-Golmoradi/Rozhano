package wisepup.customer_service.infrastructure.adapters.outgoing.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import wisepup.customer_service.application.mapper.CustomerDTOMapper;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.repository.ICustomerRepository;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaCustomerRepository implements ICustomerRepository {
    private final CustomerEntityRepository customerRepository;
    private final CustomerDTOMapper mapper;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll().stream().map(mapper).toList();
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> getCustomerByPhoneNumber(PhoneNumber phoneNumber) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {

    }
}

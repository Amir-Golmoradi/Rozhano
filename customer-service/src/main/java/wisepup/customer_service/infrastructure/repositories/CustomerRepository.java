package wisepup.customer_service.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.infrastructure.dto.CustomerDTO;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    CustomerDTO getCustomerById(Integer id);
}
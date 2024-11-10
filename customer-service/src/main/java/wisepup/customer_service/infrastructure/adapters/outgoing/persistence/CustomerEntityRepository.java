package wisepup.customer_service.infrastructure.adapters.outgoing.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.infrastructure.entity.CustomerEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerDTO> findCustomerById(UUID customerId);

    Optional<CustomerDTO> findCustomerByPhoneNumber(String phoneNumber);
}
package wisepup.customer_service.infrastructure.adapter.persistence;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.infrastructure.entity.CustomerData;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface CustomerDataJpaRepository extends JpaRepository<CustomerData, UUID> {
    boolean existsCustomerById(UUID customerId);

    boolean existsCustomerByPhoneNumber(String phoneNumber);

    Optional<CustomerData> findCustomerByPhoneNumber(String phoneNumber);

//    boolean existsCustomerByPhoneNumber(PhoneNumber phoneNumber);

}

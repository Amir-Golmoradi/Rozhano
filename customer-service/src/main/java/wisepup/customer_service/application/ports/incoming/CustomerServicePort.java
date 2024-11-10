package wisepup.customer_service.application.ports.incoming;

import org.springframework.stereotype.Service;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.request.CreatedCustomerRequest;
import wisepup.customer_service.application.dto.request.UpdatedCustomerRequest;

import java.util.List;
import java.util.UUID;

@Service
public interface CustomerServicePort {
    List<CustomerDTO> getCustomers();

    CustomerDTO registerNewCustomer(CreatedCustomerRequest request);

    CustomerDTO updateCustomer(UUID customerId, UpdatedCustomerRequest request);

    void deleteCustomer(UUID customerId);

    CustomerDTO getCustomerById(UUID customerId);
}

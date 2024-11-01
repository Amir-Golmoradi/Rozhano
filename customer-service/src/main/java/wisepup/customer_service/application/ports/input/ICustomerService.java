package wisepup.customer_service.application.ports.input;

import org.springframework.stereotype.Service;
import wisepup.customer_service.infrastructure.dto.CustomerDTO;

import java.util.List;

@Service
public interface ICustomerService {
    List<CustomerDTO> getCustomers();

    void createCustomer(CustomerDTO customer);

    void updateCustomer(CustomerDTO customer);

    void deleteCustomer(Integer customerId);

    CustomerDTO getCustomerById(Integer customerId);
}

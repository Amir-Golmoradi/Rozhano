package wisepup.customer_service.infrastructure.dto;

import org.springframework.stereotype.Component;
import wisepup.customer_service.domain.aggregates.Customer;

import java.util.function.Function;

@Component
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFullName(),
                customer.getPhoneNumber(),
                customer.getAddress()
        );
    }
}

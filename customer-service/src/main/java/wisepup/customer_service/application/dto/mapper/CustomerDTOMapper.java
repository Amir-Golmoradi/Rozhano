package wisepup.customer_service.application.dto.mapper;

import org.springframework.stereotype.Service;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.Address;

import java.util.function.Function;

@Service
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {
    @Override
    public CustomerDTO apply(Customer customer) {
        return new CustomerDTO(
                customer.getFullName().getFirstName(),
                customer.getFullName().getLastName(),
                customer.getPhoneNumber().getPhoneNumber(),
                 Address.of(
                        customer.getAddress().getCity(),
                        customer.getAddress().getStreet(),
                        customer.getAddress().getAlley(),
                        customer.getAddress().getZipCode()
                )
        );
    }
}

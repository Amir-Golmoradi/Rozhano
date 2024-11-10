package wisepup.customer_service.application.mapper;

import org.springframework.stereotype.Component;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.valueObjects.FullName;

import java.util.function.Function;

@Component
public class CustomerDTOMapper implements Function<Customer, CustomerDTO> {

    @Override
    public CustomerDTO apply(Customer customerEntity) {
        StringBuilder builder = new StringBuilder();
        var firstName = builder.append(customerEntity.getFullName().getFirstName()).toString();
        var lastName = builder.append(customerEntity.getFullName().getLastName()).toString();
        return new CustomerDTO(
                customerEntity.getId().id(),
                FullName.of(firstName, lastName),
                customerEntity.getCreatedAt()
        );
    }
}

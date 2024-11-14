package wisepup.customer_service.infrastructure.mapper;

import org.springframework.stereotype.Component;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.Address;
import wisepup.customer_service.domain.model.value_object.FullName;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.infrastructure.entity.CustomerData;

import java.util.function.Function;

@Component
public class CustomerMapper implements Function<CustomerData, Customer> {

    public CustomerData toData(Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setFirstName(customer.getFullName().getFirstName());
        customerData.setLastName(customer.getFullName().getLastName());
        customerData.setPhoneNumber(customer.getPhoneNumber().getPhoneNumber());
        customerData.setAddress(customer.getAddress().toString());
        customerData.setCreatedAt(customer.getCreatedAt());
        customerData.setUpdatedAt(customer.getUpdatedAt());
        return customerData;
    }

    @Override
    public Customer apply(CustomerData customerData) {
        return new Customer(
                new FullName(
                        customerData.getFirstName(), customerData.getLastName()
                ),
                new PhoneNumber(customerData.getPhoneNumber()),

                Address.fromFullAddress(customerData.getAddress())
        );
    }
}
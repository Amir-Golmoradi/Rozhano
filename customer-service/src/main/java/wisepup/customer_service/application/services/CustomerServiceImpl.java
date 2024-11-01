package wisepup.customer_service.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wisepup.customer_service.application.ports.input.ICustomerService;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.infrastructure.dto.CustomerDTO;
import wisepup.customer_service.infrastructure.dto.CustomerDTOMapper;
import wisepup.customer_service.infrastructure.repositories.CustomerRepository;

import java.util.List;

@Service

public class CustomerServiceImpl implements ICustomerService {
    private final CustomerDTOMapper mapper;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerDTOMapper mapper, CustomerRepository customerRepository) {
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll().stream().map(mapper).toList();
    }

    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.id(),
                customerDTO.fullName(),
                customerDTO.phoneNumber(),
                customerDTO.address()
        );
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {

    }

    @Override
    public void deleteCustomer(Integer customerId) {
        /* IMPLEMENT SOFT DELETE  */
    }

    @Override
    public CustomerDTO getCustomerById(Integer customerId) {
        return customerRepository.getCustomerById(customerId);
    }
}

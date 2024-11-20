package wisepup.customer_service.application.service.outgoing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import wisepup.customer_service.application.dto.CustomerDTO;
import wisepup.customer_service.application.dto.mapper.CustomerDTOMapper;
import wisepup.customer_service.application.port.outgoing.CustomerCreatedRequest;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.Address;
import wisepup.customer_service.domain.model.value_object.FullName;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;
import wisepup.customer_service.domain.repository.CustomerDAO;
import wisepup.customer_service.infrastructure.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerManagementServiceTest {
    private static final UUID FIXED_UUID = UUID.fromString("a0ae024d-c180-4378-83ca-08ab665d8129");

    @Mock
    private CustomerDAO customerDAO;

    @Mock
    private CustomerDTOMapper mapper;

    @InjectMocks
    private CustomerManagementService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new CustomerManagementService(mapper, customerDAO);
    }

    @Test
    void getAllCustomers_whenCalled_returnsAllMappedCustomers() {
        // GIVEN
        FullName fullName1 = new FullName("John", "Smith");
        FullName fullName2 = new FullName("John", "Doe");

        PhoneNumber phoneNumber1 = new PhoneNumber("1234567890");
        PhoneNumber phoneNumber2 = new PhoneNumber("9876543210");

        Address address1 = Address.of("Tehran", "Vanak", "Vanak Alley", "623574986");
        Address address2 = Address.of("Tehran", "ValiAsr", "ValiAsr Alley", "356274986");

        List<Customer> customers = List.of(
                new Customer(fullName1, phoneNumber1, address1),
                new Customer(fullName2, phoneNumber2, address2)
        );

        List<CustomerDTO> customerDTOs = List.of(
                new CustomerDTO(fullName1.getFirstName(), fullName1.getLastName(), phoneNumber1.getPhoneNumber(), address1),
                new CustomerDTO(fullName2.getFirstName(), fullName2.getLastName(), phoneNumber2.getPhoneNumber(), address2)
        );

        // WHEN

        // Mock customerDAO to return customers
        when(customerDAO.getAllCustomers()).thenReturn(customers);

        // Mock the mapper to convert Customer to CustomerDTO
        when(mapper.apply(customers.get(0))).thenReturn(customerDTOs.get(0));
        when(mapper.apply(customers.get(1))).thenReturn(customerDTOs.get(1));

        // THEN
        List<CustomerDTO> result = underTest.getAllCustomers();

        assertEquals(customerDTOs.get(0), result.get(0));
        assertEquals(customerDTOs.get(1), result.get(1));

        verify(customerDAO).getAllCustomers();
    }

    @Test
    void findCustomerById_whenCustomerExists_returnsMappedCustomer() {
        /* GIVEN */

        FullName fullName = new FullName("John", "Smith");
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        Address address = Address.of("Tehran", "Vanak", "Vanak Alley", "623574986");
        Customer customer = new Customer(fullName, phoneNumber, address);

        CustomerDTO customerDTO = new CustomerDTO(customer.getFullName().getFirstName(), customer.getFullName().getLastName(), customer.getPhoneNumber().getPhoneNumber(), customer.getAddress());



        /* WHEN */
        when(customerDAO.findCustomerById(FIXED_UUID)).thenReturn(Optional.of(customer));
        when(mapper.apply(customer)).thenReturn(customerDTO);
        Optional<CustomerDTO> result = underTest.findCustomerById(FIXED_UUID);

        /* THEN */
        assertTrue(result.isPresent());
        assertEquals(customerDTO, result.get());
        verify(customerDAO).findCustomerById(FIXED_UUID);
    }

    @Test
    void itShouldThrowExceptionWhenCustomerNotFound() {
        /* GIVEN */
        UUID customerId = UUID.randomUUID();

        /* WHEN */
        when(customerDAO.findCustomerById(customerId)).thenReturn(Optional.empty());

        /* THEN */
        assertThrows(CustomerNotFoundException.class, () -> underTest.findCustomerById(customerId));
    }

    @Test
    void findCustomerByPhoneNumber_whenCustomerExists_returnsMappedCustomer() {
        /* GIVEN */
        FullName fullName = new FullName("John", "Smith");
        PhoneNumber phoneNumber = new PhoneNumber("9876543210");
        Address address = Address.of("Tehran", "Vanak", "Vanak Alley", "623574986");
        Customer customer = new Customer(fullName, phoneNumber, address);
        CustomerDTO customerDTO = new CustomerDTO(customer.getFullName().getFirstName(), customer.getFullName().getLastName(), customer.getPhoneNumber().getPhoneNumber(), customer.getAddress());

        /* WHEN */
        when(customerDAO.findCustomerByPhoneNumber(phoneNumber)).thenReturn(Optional.of(customer));
        when(mapper.apply(customer)).thenReturn(customerDTO);
        Optional<CustomerDTO> result = underTest.findCustomerByPhoneNumber(phoneNumber);

        /* THEN */
        assertTrue(result.isPresent());
        assertEquals(customerDTO, result.get());
        verify(customerDAO).findCustomerByPhoneNumber(phoneNumber);
    }

    @Test
    void insertNewCustomer_whenCustomerExists_returnsMappedCustomer() {
        /* GIVEN */
        FullName fullName = new FullName("John", "Smith");
        PhoneNumber phoneNumber = new PhoneNumber("1234567890");
        Address address = Address.of(
                "Tehran",
                "Vanak",
                "Vanak Alley",
                "623574986"
        );
        CustomerCreatedRequest request = new CustomerCreatedRequest(
                fullName.getFirstName(),
                fullName.getLastName(),
                phoneNumber.getPhoneNumber(),
                address
        );

        /* WHEN */
        when(customerDAO.existsCustomerByPhoneNumber(phoneNumber)).thenReturn(false);
        underTest.insertCustomer(request);
        /* THEN */
        verify(customerDAO, times(1)).existsCustomerByPhoneNumber(phoneNumber);
        verify(customerDAO, times(1)).saveCustomer(any(Customer.class));
    }

    @Test
    void itShouldCheckExistenceOfCustomerById() {
        /* GIVEN */
        /* WHEN */
        /* THEN */

    }

    @Test
    void checkCustomerExistenceByPhoneNumber_whenCustomerExists_returnsTheCustomer() {
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        /* GIVEN */
        when(customerDAO.existsCustomerByPhoneNumber(phoneNumber)).thenReturn(true);
        /* WHEN */
        underTest.existsCustomerByPhoneNumber(phoneNumber);
        /* THEN */
        verify(customerDAO).existsCustomerByPhoneNumber(phoneNumber);
    }

    @Test
    void deleteCustomerById_whenCustomerExists_returnsDeleteTheCustomer() {
        /* GIVEN */

        // 1. Check the Customer Existence
        when(customerDAO.existsCustomerById(FIXED_UUID)).thenReturn(true);

        // 2. If Customer Exists, we deleting it .
        /* WHEN */
        underTest.deleteCustomerById(FIXED_UUID);

        /* THEN */

        verify(customerDAO).deleteCustomerById(FIXED_UUID);

    }

    @Test
    void itShouldUpdateCustomer() {
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    void itShouldSaveCustomer() {
        // GIVEN
        // WHEN
        // THEN
    }
}
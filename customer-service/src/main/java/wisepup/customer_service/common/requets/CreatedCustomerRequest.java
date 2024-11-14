package wisepup.customer_service.common.requets;

public record CreatedCustomerRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String city,
        String street,
        String alley,
        String zipCode
) {
}

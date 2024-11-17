package wisepup.customer_service.domain.model.value_object;

import lombok.Getter;

@Getter
public class Address {

    private final String city;
    private final String street;
    private final String alley;
    private final String zipCode;

    private Address(String city, String street, String alley, String zipCode) {
        this.city = city;
        this.street = street;
        this.alley = alley;
        this.zipCode = zipCode;
    }

    public static Address of(String city, String street, String alley, String zipCode) {
        return new Address(city, street, alley, zipCode);

    }


    public static Address fromFullAddress(String fullAddress) {
        String[] parts = fullAddress.split(", ");

        return new Address(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim()
        );
    }
}

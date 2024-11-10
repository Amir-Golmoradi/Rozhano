package wisepup.customer_service.domain.valueObjects;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.regex.Pattern;

@Embeddable
public class Address {
    private static final String ZIP_CODE_PATTERN = "^\\d{5,10}$";
    private static final Pattern ZIP_CODE_REGEX = Pattern.compile(ZIP_CODE_PATTERN);

    String city;
    String street;
    String alley;
    String zipCode;


    private Address(String city, String street, String alley, String zipCode) {

        this.city = Objects.requireNonNull(city, "City cannot be empty. Please provide a valid city.");
        this.street = Objects.requireNonNull(street, "Street cannot be empty. Please provide a valid street.");
        this.alley = Objects.requireNonNull(alley, "Alley cannot be empty. Please provide a valid alley.");
        this.zipCode = validateZipCode(Objects.requireNonNull(zipCode, "ZipCode cannot be empty. Please provide a valid alley."));

    }

    protected Address() {
    }


    public static Address of(String city, String street, String alley, String zipCode) {
        return new Address(city, street, alley, zipCode);
    }

    private String validateZipCode(String zipCode) {
        if (!ZIP_CODE_REGEX.matcher(zipCode).matches()) {
            throw new IllegalArgumentException("Invalid zip code. Please provide a valid zip code.");
        }
        return zipCode;
    }
}







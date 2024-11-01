package wisepup.customer_service.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@ToString
@Embeddable
@EqualsAndHashCode
public class Address {
    private static final String ZIP_CODE_PATTERN = "^\\\\d{5}-\\\\d{5}$";
    private static final Pattern ZIP_CODE_REGEX = Pattern.compile(ZIP_CODE_PATTERN);

    private final String city;
    private final String street;
    private final String alley;
    private final String zipCode;

    protected Address() {
        this.city = null;
        this.street = null;
        this.alley = null;
        this.zipCode = null;
    }

    public Address(String city, String street, String alley, String zipCode) {

        this.city = Objects.requireNonNull(city, "City cannot be empty. Please provide a valid city.");
        this.street = Objects.requireNonNull(street, "Street cannot be empty. Please provide a valid street.");
        this.alley = Objects.requireNonNull(alley, "Alley cannot be empty. Please provide a valid alley.");
        this.zipCode = validateZipCode(Objects.requireNonNull(zipCode, "ZipCode cannot be empty. Please provide a valid alley."));

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







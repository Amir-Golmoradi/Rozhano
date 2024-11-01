package wisepup.customer_service.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.regex.Pattern;

@Embeddable
@EqualsAndHashCode
@Getter
@ToString
public class PhoneNumber {
    private static final String PHONE_NUMBER_PATTERN = "^\\+98\\d{10}$";
    private final String phoneNumber;

    // Default constructor for JPA
    protected PhoneNumber() {
        this.phoneNumber = null;
    }

    public PhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber))
            throw new IllegalArgumentException("Invalid phone number");
        if (!phoneNumber.startsWith("+98"))
            phoneNumber = "+98" + phoneNumber;
        if (!Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. Please provide a phone number without 0.");
        }
    }

}

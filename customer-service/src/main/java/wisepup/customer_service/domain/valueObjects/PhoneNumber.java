package wisepup.customer_service.domain.valueObjects;

import lombok.Getter;
import lombok.Value;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.regex.Pattern;

@Value
@Getter
public class PhoneNumber {
    private static final String PHONE_NUMBER_PATTERN = "^\\+98\\d{10}$";

    String phoneNumber;


    // Factory method
    public static PhoneNumber of(String phoneNumber) {
        Assert.hasText(phoneNumber, "Phone number cannot be empty");
        validatePhoneNumber(phoneNumber);
        return new PhoneNumber(phoneNumber);
    }

    private static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber))
            Objects.requireNonNull(phoneNumber, "Phone number cannot be null");
        if (!phoneNumber.startsWith("+98"))
            phoneNumber = "+98" + phoneNumber;
        if (!Pattern.matches(PHONE_NUMBER_PATTERN, phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. Please provide a phone number without ZERO.");
        }
    }

}

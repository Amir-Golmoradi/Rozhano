package wisepup.customer_service.domain.model.value_object;

import lombok.Getter;
import lombok.Value;

import java.util.Objects;
import java.util.regex.Pattern;

@Value
@Getter
public class PhoneNumber {
    private static final String PHONE_NUMBER_PATTERN = "^\\+98[1-9][0-9]{9}$";

    String phoneNumber;

    public PhoneNumber(String value) {
        validatePhoneNumber(Objects.requireNonNull(value));
        this.phoneNumber = value;
    }


    private static void validatePhoneNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber, "Phone number cannot be null");

        // Add +98 if not present
        String formattedNumber = phoneNumber.startsWith("+98") ? phoneNumber : "+98" + phoneNumber;

        // Validate the format
        if (!Pattern.matches(PHONE_NUMBER_PATTERN, formattedNumber)) {
            throw new IllegalArgumentException("Invalid phone number format. Please provide a phone number without ZERO.");
        }
    }
}
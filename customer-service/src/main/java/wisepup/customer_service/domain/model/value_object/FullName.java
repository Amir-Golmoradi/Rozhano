package wisepup.customer_service.domain.model.value_object;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

@Getter
@EqualsAndHashCode
@ToString
@Value()
public class FullName {
    String firstName;
    String lastName;

    public FullName(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }
}


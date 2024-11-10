package wisepup.customer_service.domain.valueObjects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@EqualsAndHashCode
@ToString
public class FullName {
    private final String firstName;
    private final String lastName;

    private FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static FullName of(String firstName, String lastName) {
        return new FullName(
                Objects.requireNonNull(firstName, "First name cannot be empty"),
                Objects.requireNonNull(lastName, "Last name cannot be empty")
        );
    }

}


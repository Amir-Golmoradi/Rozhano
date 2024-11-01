package wisepup.customer_service.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
@EqualsAndHashCode
public class FullName {
    private final String firstName;
    private final String lastName;

    protected FullName() {
        this.firstName = null;
        this.lastName = null;
    }

    public FullName(String firstName, String lastName) {
        if ((firstName == null || firstName.isEmpty()) && (lastName == null || lastName.isEmpty())) {
            throw new IllegalArgumentException("Customer's name must have at least one name");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

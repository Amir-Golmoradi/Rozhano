package wisepup.customer_service.domain.aggregates;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import wisepup.customer_service.domain.valueObjects.Address;
import wisepup.customer_service.domain.valueObjects.FullName;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = "customers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_phone_number",
                        columnNames = "phone_number"
                )
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name", nullable = false)),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name", nullable = false)),
    })
    @NonNull
    private FullName fullName;

    @Embedded
    @NonNull
    private PhoneNumber phoneNumber;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city", nullable = false)),
            @AttributeOverride(name = "street", column = @Column(name = "street", nullable = false)),
            @AttributeOverride(name = "alley", column = @Column(name = "alley", nullable = false)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", nullable = false))
    })
    @NonNull
    private Address address;


    // Business logic methods

    public void updateAddress(Address newAddress) {
        if (newAddress == null)
            throw new IllegalArgumentException("Address cannot be Empty !");
        this.address = newAddress;
    }


}

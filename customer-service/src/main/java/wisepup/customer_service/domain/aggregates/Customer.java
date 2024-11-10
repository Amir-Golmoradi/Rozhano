package wisepup.customer_service.domain.aggregates;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import wisepup.customer_service.domain.valueObjects.Address;
import wisepup.customer_service.domain.valueObjects.CustomerId;
import wisepup.customer_service.domain.valueObjects.FullName;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

import java.time.Instant;

@Getter
@Setter
public class Customer {
    @EmbeddedId
    private final CustomerId id;

    @NotNull
    @Embedded
    private FullName fullName;

    @NotNull
    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "city", nullable = false)),
            @AttributeOverride(name = "street", column = @Column(name = "street", nullable = false)),
            @AttributeOverride(name = "alley", column = @Column(name = "alley", nullable = false)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", nullable = false))
    })
    @NotNull
    private Address address;

    private Instant createdAt;
    private Instant updatedAt;

    public Customer(FullName fullName, PhoneNumber phoneNumber, Address address) {
        this.id = new CustomerId();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public void updatePersonalInfo(FullName fullName) {
        this.fullName = fullName;
    }
    public void updateDeliveryAddress(Address address) {
        this.address = address;
    }
}



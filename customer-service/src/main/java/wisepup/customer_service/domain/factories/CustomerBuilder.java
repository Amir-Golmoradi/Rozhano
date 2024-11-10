package wisepup.customer_service.domain.factories;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import wisepup.customer_service.domain.aggregates.Customer;
import wisepup.customer_service.domain.valueObjects.Address;
import wisepup.customer_service.domain.valueObjects.FullName;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

import java.time.Instant;
import java.util.UUID;

@Service
public class CustomerBuilder {
    public UUID customerId;
    public FullName fullName;
    public PhoneNumber phoneNumber;
    public Address address;
    public Instant createdAt;
    public Instant updatedAt;

    public CustomerBuilder withId(UUID id) {
        this.customerId = id;
        return this;
    }

    public CustomerBuilder withFullName(@NotNull String firstName, @NotNull String lastName) {
        this.fullName = FullName.of(firstName, lastName);
        return this;
    }

    public CustomerBuilder withPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = PhoneNumber.of(phoneNumber);
        return this;
    }

    public CustomerBuilder withAddress(@NotNull String city, @NotNull String street, @NotNull String alley, @NotNull String zipCode) {
        this.address = Address.of(city, street, alley, zipCode);
        return this;
    }

    public CustomerBuilder withCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CustomerBuilder withUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public Customer build() {
        validateCustomer();
        return new Customer(
                this.fullName,
                this.phoneNumber,
                this.address
        );
    }

    private void validateCustomer() {
        if (fullName == null) throw new IllegalStateException("FullName is required");
        if (phoneNumber == null) throw new IllegalStateException("PhoneNumber is required");
        if (address == null) throw new IllegalStateException("Address is required");
    }
}
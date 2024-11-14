package wisepup.customer_service.domain.model.factories;

import jakarta.validation.constraints.NotNull;
import wisepup.customer_service.domain.aggregate.Customer;
import wisepup.customer_service.domain.model.value_object.Address;
import wisepup.customer_service.domain.model.value_object.FullName;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;

import java.time.Instant;
import java.util.UUID;

public class CustomerBuilder {

    private UUID id;
    private FullName fullName;
    private PhoneNumber phoneNumber;
    private Address address;
    private Instant createdAt;
    private Instant updatedAt;

    public CustomerBuilder() {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    // Factory methods
    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(@NotNull UUID id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withFullName(@NotNull String firstName, @NotNull String lastName) {
        this.fullName = new FullName(firstName, lastName);
        return this;
    }

    public CustomerBuilder withPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = new PhoneNumber(phoneNumber);
        return this;
    }

    public CustomerBuilder withAddress(@NotNull String city, @NotNull String street,
                                       @NotNull String alley, @NotNull String zipCode) {
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
        if (id == null) throw new IllegalStateException("Id is required");
        if (fullName == null) throw new IllegalStateException("FullName is required");
        if (phoneNumber == null) throw new IllegalStateException("PhoneNumber is required");
        if (address == null) throw new IllegalStateException("Address is required");
        if (createdAt == null) throw new IllegalStateException("CreatedAt is required");
        if (updatedAt == null) throw new IllegalStateException("UpdatedAt is required");
    }
}



package wisepup.customer_service.domain.aggregate;

import lombok.Getter;
import wisepup.customer_service.common.CustomerStatus;
import wisepup.customer_service.domain.model.value_object.Address;
import wisepup.customer_service.domain.model.value_object.CustomerId;
import wisepup.customer_service.domain.model.value_object.FullName;
import wisepup.customer_service.domain.model.value_object.PhoneNumber;

import java.time.LocalDateTime;

@Getter
public class Customer {
    private final CustomerId id;
    private final FullName fullName;
    private final PhoneNumber phoneNumber;
    private final Address address;
    private final CustomerStatus status;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Customer(
            FullName fullName,
            PhoneNumber phoneNumber,
            Address address
    ) {
        this.id = new CustomerId();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = CustomerStatus.ACTIVE;
    }
}



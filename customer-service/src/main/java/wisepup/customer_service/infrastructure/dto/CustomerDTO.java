package wisepup.customer_service.infrastructure.dto;

import wisepup.customer_service.domain.valueObjects.Address;
import wisepup.customer_service.domain.valueObjects.FullName;
import wisepup.customer_service.domain.valueObjects.PhoneNumber;

public record CustomerDTO(
        Integer id,
        FullName fullName,
        PhoneNumber phoneNumber,
        Address address
) {
}

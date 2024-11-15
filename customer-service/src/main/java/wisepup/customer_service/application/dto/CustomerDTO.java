package wisepup.customer_service.application.dto;

import wisepup.customer_service.domain.model.value_object.Address;

public record CustomerDTO(
        String firstName,
        String lastName,
        String phoneNumber,
        Address address
) {
}

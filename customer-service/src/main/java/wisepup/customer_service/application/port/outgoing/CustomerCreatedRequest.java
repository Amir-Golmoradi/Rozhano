package wisepup.customer_service.application.port.outgoing;

import wisepup.customer_service.domain.model.value_object.Address;

public record CustomerCreatedRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        Address address
) {

}

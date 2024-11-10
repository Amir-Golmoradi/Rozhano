package wisepup.customer_service.application.dto;


import wisepup.customer_service.domain.valueObjects.FullName;

import java.time.Instant;
import java.util.UUID;

public record CustomerDTO(
        UUID id,
        FullName fullName,
        Instant createdAt
) {
    public void updatePersonalInfo(String firstName, String lastName) {

    }
}

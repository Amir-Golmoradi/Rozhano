package wisepup.customer_service.application.port.outgoing;

import lombok.Data;
import wisepup.customer_service.application.dto.AddressDTO;

import java.util.UUID;

@Data
public class CustomerResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTO address;
    private String status;
}

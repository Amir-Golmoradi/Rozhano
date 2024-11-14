package wisepup.customer_service.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "Alley is required")
    private String alley;
    @NotBlank(message = "ZipCode is required")
    private String zipCode;
}

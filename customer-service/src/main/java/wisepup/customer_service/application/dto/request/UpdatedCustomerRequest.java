package wisepup.customer_service.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatedCustomerRequest {
    @NotNull(message = "Personal information is required")
    UpdatedCustomerRequest.PersonalInfoDTO personalInfo;

    @NotNull(message = "Delivery address is required")
    UpdatedCustomerRequest.DeliveryAddressDTO deliveryAddress;

    public record PersonalInfoDTO(
            @NotBlank(message = "Hey there, you forget to tell us your firstname :)") @Pattern(regexp = "^[A-Za-z]{2,50}$", message = "First name must be between 2 and 50 characters and contain only letters") String firstName,
            @NotBlank(message = "Hey there, you forget to tell us your lastname :)") @Pattern(regexp = "^[A-Za-z]{2,50}$", message = "Last name must be between 2 and 50 characters and contain only letters") String lastName
    ) {
    }

    public record DeliveryAddressDTO(
            @NotBlank(message = "City is required") @Size(min = 2, max = 100, message = "City name, must be between 2 and 100 characters") String city,
            @NotBlank(message = "Street is required") @Size(min = 5, max = 200, message = "Street name, must be between 5 and 200 characters") String street,
            @Size(max = 100, message = "Alley name, cannot exceed 100 characters") String alley,
            @Pattern(regexp = "^\\d{5,10}$", message = "Invalid zip code format") String zipCode,
            @Size(max = 500, message = "Additional delivery instructions cannot exceed 500 characters") String deliveryInstructions) {
    }
}

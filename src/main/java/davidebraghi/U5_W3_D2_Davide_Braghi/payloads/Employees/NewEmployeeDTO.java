package davidebraghi.U5_W3_D1_Davide_Braghi.payloads.Employees;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record NewEmployeeDTO(
        @NotEmpty(message = "Mandatory field: insert username")
        String username,
        @NotEmpty(message = "Mandatory field: insert surname")
        String surname,
        @NotEmpty(message = "Mandatory field: insert name")
        String name,
        @NotEmpty(message = "Mandatory field: insert email")
        @Email
        String email,
        @NotBlank(message = "Mandatory field: insert valid password")
        String password
) {
}

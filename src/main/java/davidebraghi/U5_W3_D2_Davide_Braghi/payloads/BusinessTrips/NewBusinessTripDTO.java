package davidebraghi.U5_W3_D1_Davide_Braghi.payloads.BusinessTrips;

import davidebraghi.U5_W3_D1_Davide_Braghi.enums.BusinessTripStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewBusinessTripDTO(
        @NotEmpty(message = "Mandatory field: insert destination")
        String destination,
        @NotEmpty(message = "Mandatory field: insert date")
        @FutureOrPresent
        LocalDate date,
        @NotEmpty(message = "Mandatory field: insert status")
        BusinessTripStatus status
) {
}
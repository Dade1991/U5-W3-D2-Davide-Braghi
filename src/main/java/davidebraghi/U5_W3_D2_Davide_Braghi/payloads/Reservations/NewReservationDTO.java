package davidebraghi.U5_W3_D1_Davide_Braghi.payloads.Reservations;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.BusinessTrip;
import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Employee;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record NewReservationDTO(
        @NotNull(message = "Mandatory field: insert date")
        LocalDate reservationDate,
        String notes,
        @NotNull
        Employee employee,
        @NotNull
        BusinessTrip businessTrip
) {
}
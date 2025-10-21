package davidebraghi.U5_W3_D1_Davide_Braghi.payloads.BusinessTrips;

import davidebraghi.U5_W3_D1_Davide_Braghi.enums.BusinessTripStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateBusinessTripStatusDTO(
        @NotNull
        BusinessTripStatus status
) {
}

package davidebraghi.U5_W3_D2_Davide_Braghi.payloads;

import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timestamp) {
}

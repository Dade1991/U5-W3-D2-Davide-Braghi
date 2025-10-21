package davidebraghi.U5_W3_D2_Davide_Braghi.payloads;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorsWithListDTO(String message,
                                LocalDateTime timestamp,
                                List<String> errorList) {
}

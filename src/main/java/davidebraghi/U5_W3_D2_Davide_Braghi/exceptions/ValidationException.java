package davidebraghi.U5_W3_D2_Davide_Braghi.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends RuntimeException {
    private List<String> errorsMessages;

    public ValidationException(List<String> errorsMessages) {
        super("Errors occurs during validation.");
        this.errorsMessages = errorsMessages;
    }
}

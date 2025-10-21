package davidebraghi.U5_W3_D1_Davide_Braghi.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("ID: " + id + " was not found. Try again.");
    }

    public NotFoundException(String msg) {
        super(msg);
    }
}

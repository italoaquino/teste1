package pgfn.gov.transfer.services.exceptions;

public class IOException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public IOException(String message, Throwable cause) {
        super(message, cause);
    }

    public IOException(String message) {
        super(message);
    }

}
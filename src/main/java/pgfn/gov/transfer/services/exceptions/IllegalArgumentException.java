package pgfn.gov.transfer.services.exceptions;

public class IllegalArgumentException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public IllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalArgumentException(String message) {
        super(message);
    }
    
}

package pgfn.gov.transfer.dto;

public class UploadFileResponse {

    private String message;

    public UploadFileResponse() {
    }

    public UploadFileResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
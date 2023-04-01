package AsyncProgramming;

public class ResponseHandler {
    private String message;
    private String responseCode;

    public ResponseHandler() {
    }

    public ResponseHandler(String message, String responseCode) {
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    @Override
    public String toString() {
        return "ResponseHandler{" +
                "message='" + message + '\'' +
                ", responseCode='" + responseCode + '\'' +
                '}';
    }
}

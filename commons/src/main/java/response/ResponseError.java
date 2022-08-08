package response;

public enum ResponseError {

    NOT_FOUND("Generic code for errors where an entity is not found"),
    INTERNAL_SERVER_ERROR("Internal server error");

    private String errorMessage;

    ResponseError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ResponseError withCustomErrorMessage(String errorMessage) {
        String colon = ": ";
        if (this.errorMessage.contains(colon)) {
            this.errorMessage = this.errorMessage.substring(0, this.errorMessage.indexOf(colon));
        }
        this.errorMessage = this.errorMessage.concat(colon).concat(errorMessage);
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

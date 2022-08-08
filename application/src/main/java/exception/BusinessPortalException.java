package exception;

import response.common.ResponseError;

public class BusinessPortalException extends RuntimeException {

    private final ResponseError responseErrorCode;

    public BusinessPortalException(ResponseError responseErrorCode) {
        super(String.valueOf(responseErrorCode));
        this.responseErrorCode = responseErrorCode;
    }

    public BusinessPortalException(ResponseError responseErrorCode, Exception ex) {
        super(String.valueOf(responseErrorCode), ex);
        this.responseErrorCode = responseErrorCode;
    }

    public BusinessPortalException(ResponseError responseErrorCode, String message) {
        super(message);
        this.responseErrorCode = responseErrorCode;
    }

    public ResponseError getResponseErrorCode() {
        return responseErrorCode;
    }
}

package response.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import exception.BusinessPortalException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
public class Response<T> {

    private final String status;
    private final T data;
    private ResponseError errorCode;
    private final List<ErrorDetails> errors;

    public static final Response SUCCESS = new Response<>();

    protected Response() {
        this.status = Consts.SUCCESS;
        this.data = null;
        this.errors = Collections.emptyList();
    }

    public Response(T data) {
        this.status = Consts.SUCCESS;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public Response(String status, ResponseError errorCode) {
        this.status = status;
        this.data = null;
        this.errorCode = errorCode;
        this.errors = Collections.emptyList();
    }

    public Response(T data, ResponseError errorCode) {
        this.status = Consts.SUCCESS;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = Collections.emptyList();
    }

    public Response(T data, String status) {
        this.status = status;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public Response(T data, final List<ErrorDetails> errorDetails, ResponseError errorCode) {
        this.status = Consts.ERROR;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = errorDetails == null ? Collections.emptyList() : errorDetails;
    }

    public Response(final T data, final String status, final List<ErrorDetails> errorDetails, final ResponseError errorCode) {
        this.status = status;
        this.data = data;
        this.errorCode = errorCode;
        this.errors = errorDetails == null ? Collections.emptyList() : errorDetails;
    }

    protected <T> Response(final List<ErrorDetails> errorDetails, ResponseError errorCode) {
        this.status = Consts.ERROR;
        this.data = null;
        this.errorCode = errorCode;
        this.errors = errorDetails == null ? Collections.emptyList() : errorDetails;
    }

    protected Response(final List<ErrorDetails> errorDetails) {
        this.status = Consts.ERROR;
        this.data = null;
        this.errors = errorDetails == null ? Collections.emptyList() : errorDetails;
    }

    public static <T> Response<T> successfulResponse(T data) {
        return new Response<T>(data);
    }

    public static <T> Response<T> warningResponse(T data) {
        return new Response<T>(data, Consts.WARNING);
    }
    
    public static <T> Response<T> errorResponse(String... errors) {
        return new Response<T>(Arrays.stream(errors).map(x -> ErrorDetails.builder().message(x).build())
                                   .collect(Collectors.toList()));
    }

    public static <T> Response<T> errorResponse(ResponseError errorCode, String... errors) {
        Response<T> response = new Response<T>(Arrays.stream(errors).map(x -> ErrorDetails.builder().message(x).build())
                                   .collect(Collectors.toList()));
        response.errorCode = errorCode;
        return response;
    }
    
    public static <T> Response<T> errorResponse(List<ErrorDetails> errorDetails, ResponseError errorCode) {
        return new Response<T>(errorDetails, errorCode);
    }

    public static <T> Response<T> errorResponse(List<ErrorDetails> errorDetails, ResponseError errorCode, String status) {
        return new Response<T>(null, status, errorDetails, errorCode);
    }

    public static <T> Response<T> errorResponse(ResponseError errorCode) {
        return new Response<T>(Collections.singletonList(ErrorDetails.builder().message(errorCode.getErrorMessage()).build()), errorCode);
    }

    public static <T> Response errorResponse(BusinessPortalException ex) {
        return new Response<T>(Collections.singletonList(ErrorDetails.builder().message(ex.getResponseErrorCode().getErrorMessage()).build()), ex.getResponseErrorCode());
    }

    @JsonIgnore
    public boolean isSuccessful() {
        return Consts.SUCCESS.equalsIgnoreCase(this.getStatus());
    }
}
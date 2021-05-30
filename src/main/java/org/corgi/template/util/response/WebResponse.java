package org.corgi.template.util.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebResponse<T> implements Serializable {

    private T data;
    private ErrorResponseData<T> error;

    public static <T> WebResponse<T> buildData(T data) {
        WebResponse<T> webResponse = new WebResponse<>();
        webResponse.setData(data);
        return webResponse;
    }

    public static <T> WebResponse<T> buildError(ErrorResponseData<T> error) {
        WebResponse<T> webResponse = new WebResponse<>();
        webResponse.setError(error);
        return webResponse;
    }

    public static <T> WebResponse<T> buildError(int code, String msg, T domain) {
        WebResponse<T> webResponse = new WebResponse<>();
        webResponse.setError(new ErrorResponseData<>(code, msg, domain));
        return webResponse;
    }

    public static <T> WebResponse<T> buildError(int code, String msg) {
        WebResponse<T> webResponse = new WebResponse<>();
        webResponse.setError(new ErrorResponseData<>(code, msg));
        return webResponse;
    }
}

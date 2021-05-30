package org.corgi.template.util.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseData<T> {

    private int code;
    private String msg;
    private T domain;

    public ErrorResponseData(int code, String msg, T domain) {
        this.code = code;
        this.msg = msg;
        this.domain = domain;
    }

    public ErrorResponseData(int code, String msg) {
        this(code, msg, null);
    }
}

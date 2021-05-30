package org.corgi.template.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TestEnum {
    ONE(0, "FIRST"),
    TWO(1, "SECOND");

    @EnumValue
    private final int code;

    @JsonValue
    private final String descp;
}

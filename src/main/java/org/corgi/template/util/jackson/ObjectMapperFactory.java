package org.corgi.template.util.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
    private static ObjectMapper INSTANCE;

    private ObjectMapperFactory() {
    }

    public static ObjectMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ObjectMapper();

            //忽略未定义的字段
            INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return INSTANCE;
    }
}

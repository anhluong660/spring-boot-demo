package com.royalhek17.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class SampleUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        try {
            T target = clazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            log.error("SampleUtils:copyProperties Error: {}", e.getMessage());
            return null;
        }
    }

    public static <T> T deepCopyProperties(Object source, Class<T> clazz) {
        try {
            String json = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("SampleUtils:copyProperties2 Error: {}", e.getMessage());
            return null;
        }
    }
}

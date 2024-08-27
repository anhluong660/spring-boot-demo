package com.royalhek17.utils;

import org.springframework.beans.BeanUtils;

public class SampleUtils {

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        try {
            T target = clazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            return null;
        }
    }
}

package com.royalhek17.utils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class SampleUtils {

    private static boolean isBasicType(Class<?> clazz) {
        return Number.class.isAssignableFrom(clazz)
                || clazz == String.class
                || clazz == Date.class
                || clazz == LocalDate.class
                || clazz == LocalDateTime.class
                ;
    }

    private static void copyBasicValue(Field field, Object source, Object target) {
        try {
            field.setAccessible(true);
            Object value = field.get(source);

            Field targetField = target.getClass().getDeclaredField(field.getName());
            targetField.setAccessible(true);
            targetField.set(target, value);
        } catch (Exception ignore) {

        }
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        try {
            T target = targetClass.newInstance();

            Class<?> sourceClass = source.getClass();
            Field[] fields = sourceClass.getDeclaredFields();

            for (Field field : fields) {
                if (isBasicType(field.getType())) {
                    copyBasicValue(field, source, target);
                }
            }

            return target;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

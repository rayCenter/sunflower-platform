package com.center.common.error;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public abstract class AssertUtils {

    public static void isNotBlank(final CharSequence cs, String message) {
        if (cs == null || cs.length() == 0) {
            throw new BusinessException(message);
        }
    }

    public static void isBlank(final CharSequence cs, String message) {
        final int strLen = StringUtils.length(cs);
        if (strLen == 0) {
            return;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                throw new BusinessException(message);
            }
        }
    }

    public static void isNotEmpty(final Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
        if (object instanceof CharSequence) {
            if (((CharSequence) object).length() == 0) {
                throw new BusinessException(message);
            }
        }
        if (object.getClass().isArray()) {
            if (Array.getLength(object) == 0) {
                throw new BusinessException(message);
            }
        }
        if (object instanceof Collection<?>) {
            if (((Collection<?>) object).isEmpty()) {
                throw new BusinessException(message);
            }
        }
        if (object instanceof Map<?, ?>) {
            if (((Map<?, ?>) object).isEmpty()) {
                throw new BusinessException(message);
            }
        }
    }
}

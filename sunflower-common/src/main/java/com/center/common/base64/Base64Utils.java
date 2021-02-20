package com.center.common.base64;

import com.center.common.error.BusinessException;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Pattern;

public class Base64Utils {

    public static String encode(String encodeStr) {
        if (StringUtils.isBlank(encodeStr)) {
            throw new BusinessException(String.format("jdk1.8编码错误 - 接口参数 - [%s]", encodeStr));
        }
        return Base64.getEncoder().encodeToString(encodeStr.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String decodeStr) {
        if (StringUtils.isBlank(decodeStr)) {
            throw new BusinessException(String.format("jdk1.8解码错误 - 接口参数 - [%s]", decodeStr));
        }
        return new String(Base64.getDecoder().decode(decodeStr), StandardCharsets.UTF_8);
    }

    public static boolean isBase64(String str) {
        if (StringUtils.isNotBlank(str)) {
            String base64Pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
            return Pattern.matches(base64Pattern, str);
        }
        return false;
    }
}

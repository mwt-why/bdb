package com.why.bdb;

import java.util.Objects;

public class BaseUtil {

    private BaseUtil() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param s
     * @return
     */
    public static boolean isEmptyString(String s) {
        return Objects.nonNull(s) && s.trim().isEmpty();
    }
}

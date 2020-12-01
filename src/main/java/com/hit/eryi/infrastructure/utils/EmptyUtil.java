package com.hit.eryi.infrastructure.utils;

import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * <p> EmptyUtil </p>
 * <p> 描述： 判断对象是否为空工具类 </p>
 */
public class EmptyUtil {
    /**
     * 判断对象为空
     *
     * @param obj
     *            对象名
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        //null
        if (obj == null) {
            return true;
        }
        //String
        if (obj instanceof String) {
            return ((String) obj).trim().equals("");
        }
        //Others
        return  ObjectUtils.isEmpty(obj);

    }

    /**
     * 判断对象不为空
     *
     * @param obj
     *            对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}

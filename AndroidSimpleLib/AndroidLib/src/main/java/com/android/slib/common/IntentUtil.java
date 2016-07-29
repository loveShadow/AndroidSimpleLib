package com.android.slib.common;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;

/**
 * Created by zhaoli on 2016/7/21.
 *
 * 关于 Intent 的帮助类
 */
public class IntentUtil {
    /**
     * Intent 转换为 String
     * @param intent Intent
     * @return String (内部的键值打印)
     */
    public static String intentToString(Intent intent) {
        //URI_INTENT_SCHEME

        Bundle extras = intent.getExtras();

        if (null == extras) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer("\nintent = \n");
            for (String key : extras.keySet()) {
                final Object value = extras.get(key);
                String entryType =
                    value instanceof String    ? "String   " :
                    value instanceof Boolean   ? "Boolean  " :
                    value instanceof Byte      ? "Byte     " :
                    value instanceof Character ? "Character" :
                    value instanceof Double    ? "Double   " :
                    value instanceof Float     ? "Float    " :
                    value instanceof Integer   ? "Integer  " :
                    value instanceof Long      ? "Long     " :
                    value instanceof Short     ? "Short    " :
                    value instanceof int[]     ? "int[]    " :
                    value instanceof short[]   ? "short[]  " :
                    value instanceof long[]    ? "long[]   " :
                    value instanceof float[]   ? "float[]  " :
                    value instanceof char[]    ? "char[]   " :
                    value instanceof byte[]    ? "byte[]   " :
                    value instanceof double[]  ? "double[] " :
                    value instanceof boolean[] ? "boolean[]" :
                    "";
                if (entryType.isEmpty() && null != value) {
                    entryType = value.getClass().getSimpleName();
                }

                sb.append("[type  : " + entryType + "]\t");
                sb.append("[key   : " + key + "]\t");

                String arrayValue = getArrayValue(value);
                if (arrayValue.isEmpty()) {
                    arrayValue = ((value != null) ? value.toString() : "null");
                }
                sb.append("[value : " + arrayValue + "]\t\n");
            }
            return sb.toString();
        }
    }

    private static String getArrayValue(Object value) {
        //属于基础数据类型
        if (value instanceof int[]) {
            return Arrays.toString((int[]) value);
        } else if (value instanceof byte[]) {
            return Arrays.toString((byte[]) value);
        } else if (value instanceof float[]) {
            return Arrays.toString((float[]) value);
        } else if (value instanceof double[]) {
            return Arrays.toString((double[]) value);
        } else if (value instanceof long[]) {
            return Arrays.toString((long[]) value);
        } else if (value instanceof boolean[]) {
            return Arrays.toString((boolean[]) value);
        } else if (value instanceof short[]) {
            return Arrays.toString((short[]) value);
        } else if (value instanceof char[]) {
            return Arrays.toString((char[]) value);
        }
        return "";
    }
}

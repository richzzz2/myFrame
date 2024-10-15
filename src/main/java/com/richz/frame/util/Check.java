package com.richz.frame.util;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class Check {

    public static boolean isEquals(final Object param1,final Object param2) {
        return Objects.equals(param1,param2);
    }
    public static boolean isNullObj(final Object checkObject) {
        if(checkObject == null || "".equals(checkObject)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNullStr(final String checkString) {
        if (isNullObj(checkString) || (checkString.trim().length() == 0) || "null".equals(checkString) || checkString.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNullList(final List<?> listObj){
        if(isNullObj(listObj) || listObj.size()<=0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isNullArray(final Object[] array) {
        if(isNullObj(array) || array.length<=0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isNullMap(final Map<?,?> mapObj){
        if(isNullObj(mapObj) || mapObj.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

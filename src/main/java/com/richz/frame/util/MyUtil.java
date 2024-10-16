package com.richz.frame.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import lombok.extern.slf4j.Slf4j;
import org.owasp.esapi.ESAPI;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class MyUtil {

    private static final SerializeConfig serializeConfig;

    static {
        serializeConfig = new SerializeConfig();
        serializeConfig.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static String encodeParseJson(Object o) {
        String param = null;
        if (o instanceof List) {
            JSONArray jsonArray = (JSONArray) JSON.toJSON(o);
            param = JSON.toJSONString(jsonArray, serializeConfig,
                    SerializerFeature.WriteDateUseDateFormat,
                    SerializerFeature.WriteMapNullValue);
        } else {
            JSONObject json = (JSONObject) JSON.toJSON(o);
            param = JSON.toJSONString(json, serializeConfig,
                    SerializerFeature.WriteDateUseDateFormat,
                    SerializerFeature.WriteMapNullValue);
        }
        log.warn("------------源数据-----------");
        System.out.println(o.toString());
        return ESAPI.encoder().encodeForJavaScript(param);
    }
    public static String isNull(Object arg){
        if (arg == null){
            return null;
        }else {
            return String.valueOf(arg);
        }
    }
    /***
    * @FunctionName: fileParseJson
    * @Description: json文件转对象
    * @author: richz
    * @date: 2024/7/18 12:25
     * @param filePath
    * @Return: JSONObject
    */
    public static JSONObject fileParseJson(String filePath) throws IOException {
        File jsonFile = new File(filePath);
        String jsonStr = "";
        FileReader fileReader = new FileReader(jsonFile);

        Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
        int ch = 0;
        StringBuffer sb = new StringBuffer();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        jsonStr = sb.toString();
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        return jsonObject;
    }
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static BigDecimal div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }
    public static <T> List<T> paginate(List<T> list, int pageSize, int pageNumber) {
        int fromIndex = (pageNumber - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, list.size());

        // 检查页码是否超出范围
        if (fromIndex >= list.size() || fromIndex < 0) {
            return new ArrayList<>(); // 返回空列表
        }

        return list.subList(fromIndex, toIndex);
    }
}

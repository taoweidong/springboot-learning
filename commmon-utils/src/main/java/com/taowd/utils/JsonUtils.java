package com.taowd.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName JsonUtils
 * @Description TODO
 * @Author Taowd
 * @Date 2018/6/4 22:53
 * @Version V1.0
 */
public class JsonUtils {

    /**
     * 将JavaBean转为Json串
     *
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        return JSONObject.toJSONString(object);
    }
}

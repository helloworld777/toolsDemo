package com.lxl.lu.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/5/5.
 */
public class JsonUtil {

    public static <T> List<T> getBeansFromJson(Class<?> clazz, String jsons){
        String[] json=jsons.replace("[", "").replace("]", "").split("},");
        List<T> ts=new ArrayList<T>();
        for(String j:json){
            T t=getBeanFromJson(clazz,j);
            ts.add(t);
        }
        return ts;
    }
    public static <T> T getBeanFromJson(Class<?> clazz,String json){
        T t=null;
        try {
            Field[] fs=clazz.getDeclaredFields();
            Constructor[] cs=clazz.getDeclaredConstructors();
            Object args[]=new String[cs[0].getParameterTypes().length];

            t=(T)cs[0].newInstance(args);
            String[] fields=json.replace("\"", "").replace("{","").replace("}", "").trim().split(",");
            for(String field:fields){
                String[] values=field.split(":");
                Field f=clazz.getDeclaredField(values[0]);
                if(f!=null){
                    f.setAccessible(true);
                    f.set(t, values[1]);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}

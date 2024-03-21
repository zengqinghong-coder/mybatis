package com.zqh.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author 曾庆红
 * @create 2024-03-20 15:35
 */

public class MapperProxyFactory<T>{

    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }
    @SuppressWarnings("unchecked")
    public T newInstance(Map<String,String> sqlSession){
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }

}

package com.zqh.mybatis.binding;

import com.zqh.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:10
 */

public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    @SuppressWarnings("unchecked")
    public  T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession,mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}

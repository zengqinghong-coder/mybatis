package com.zqh.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.zqh.mybatis.session.SqlSession;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:20
 */

public class MapperRegistry {

    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        MapperProxyFactory<T> mapperProxyFactory =(MapperProxyFactory<T>) knownMappers.get(type);
        if (null == mapperProxyFactory){
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> boolean hasMapper(Class<T> type){
        return knownMappers.containsKey(type);
    }
    public <T> void addMapper(Class<T> type){
        if (type.isInterface()){
            if (hasMapper(type)){
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            boolean loadCompleted  = false;
            try{
                knownMappers.put(type,new MapperProxyFactory<>(type));
                loadCompleted = true;
            }finally {
                if (!loadCompleted){
                    knownMappers.remove(type);
                }
            }
        }
    }

    public void addMappers(String packageName){
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapper: mapperSet){
            addMapper(mapper);
        }
    }
}

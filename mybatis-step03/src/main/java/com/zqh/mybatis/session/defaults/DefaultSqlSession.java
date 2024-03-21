package com.zqh.mybatis.session.defaults;

import com.zqh.mybatis.binding.MapperRegistry;
import com.zqh.mybatis.session.SqlSession;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:40
 */

public class DefaultSqlSession implements SqlSession {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry){
        this.mapperRegistry = mapperRegistry;
    }
    @Override
    public <T> T selectOne(String statement) {
        return (T)("你被代理了！代理方法为: "+ statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T)("你被代理了！代理方法为: "+ statement+"传入参数为: "+ parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}

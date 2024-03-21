package com.zqh.mybatis.session.defaults;

import com.zqh.mybatis.binding.MapperRegistry;
import com.zqh.mybatis.session.SqlSession;
import com.zqh.mybatis.session.SqlSessionFactory;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:43
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry){
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}

package com.zqh.mybatis.session;

import com.zqh.mybatis.binding.MapperRegistry;

/**
 * @author 曾庆红
 * {@code @date} 2024-03-21 23:33
 */

public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
 }

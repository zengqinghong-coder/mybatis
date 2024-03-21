package com.zqh.mybatis.session;

import java.io.Closeable;

/**
 * @author 曾庆红
 * @description SqlSession 用来执行SQL，获取映射器，管理事务
 * 通常情况下，我们在应用程序中使用的mybatis的API就是这个接口定义的方法
 * {@code @date} 2024-03-21 17:22
 */

public interface SqlSession /*extends Closeable*/ {

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * 根据指定的SqlID获取一条记录的封装对象
     * @param statement SqlID
     * @return Mapped object 封装后的对象
     * @param <T> the returned object type 封装之后的对象类型
     */
    <T> T selectOne(String statement);

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     * @param <T>
     *          the returned object type
     * @param statement
     *          Unique identifier matching the statement to use.
     * @param parameter
     *          A parameter object to pass to the statement.
     *
     * @return Mapped object
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * Retrieves a mapper.
     * 得到映射器，这个巧妙的使用了泛型，使得类型安全
     * @param <T>
     *          the mapper type
     * @param type
     *          Mapper interface class
     *
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}

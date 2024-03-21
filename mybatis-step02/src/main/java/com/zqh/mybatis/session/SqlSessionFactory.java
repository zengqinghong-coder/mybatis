package com.zqh.mybatis.session;

/**
 * @author 曾庆红
 * Creates an {@link SqlSession} out of a connection or a DataSource
 * @description 工厂模式接口，构建SqlSession的工厂
 * {@code @date} 2024-03-21 17:39
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}

package com.zqh.mybatis.session;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:35
 */

public interface SqlSessionFactory {

    SqlSession openSession();
}

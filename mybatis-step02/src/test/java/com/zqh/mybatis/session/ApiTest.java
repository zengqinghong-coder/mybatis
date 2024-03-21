package com.zqh.mybatis.session;

import com.zqh.mybatis.binding.MapperRegistry;
import com.zqh.mybatis.session.dao.IUserDao;
import com.zqh.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 曾庆红
 * @create 2024-03-21 22:32
 */

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testMapperProxyFactory(){
        //注册
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.zqh.mybatis.session.dao");
        //创建SqlSessionFactory
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = defaultSqlSessionFactory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        String integer = mapper.queryUserName("1001");
        String s = mapper.queryAll();
        logger.info("测试结果{}",integer);
        logger.info("测试无参方法{}",s);
    }
}

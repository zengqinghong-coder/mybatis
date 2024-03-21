package com.zqh.mybatis.binding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.zqh.mybatis.binding.dao.IUserDao;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author 曾庆红
 * @create 2024-03-20 16:01
 */

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testMapperProxyFactory(){
        MapperProxyFactory<IUserDao> mapperProxyFactory = new MapperProxyFactory<>(IUserDao.class);

        HashMap<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.zqh.mybatis.binding.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.zqh.mybatis.binding.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = mapperProxyFactory.newInstance(sqlSession);

        String res = userDao.queryUserName("1001");
        logger.info("测试结果：{}",res);
    }

    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果：" + result);
    }

}

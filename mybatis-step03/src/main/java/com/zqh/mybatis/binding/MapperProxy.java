package com.zqh.mybatis.binding;

import com.zqh.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 曾庆红
 * @create 2024-03-21 23:10
 */

public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;

    private final  SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession,Class<T> mapperInterface){
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else{
            return sqlSession.selectOne(method.getName(),args);
        }
    }
}

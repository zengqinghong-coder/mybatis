package com.zqh.mybatis.binding.dao;

/**
 * @author 曾庆红
 * {@code @date} 2024-03-20 16:01
 */

public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}

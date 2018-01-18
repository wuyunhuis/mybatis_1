package cn.itheima.mybatis.dao;

import cn.itheima.mybatis.entity.User;

public interface UserDao {
  //根据id查询用户
	public User findUserById(Integer id);
}

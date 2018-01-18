package cn.itheima.mybatis.mapping;

import cn.itheima.mybatis.entity.User;

public interface UserMapper {
    public User findUserById(Integer id);
}

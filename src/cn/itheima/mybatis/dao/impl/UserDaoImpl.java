package cn.itheima.mybatis.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itheima.mybatis.dao.UserDao;
import cn.itheima.mybatis.entity.User;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
    	this.sqlSessionFactory=sqlSessionFactory;
    }
	@Override
	public User findUserById(Integer id) {
		 SqlSession sqlSession=sqlSessionFactory.openSession();
		 User user=sqlSession.selectOne("findUserById",id);
		return user;
	}

}

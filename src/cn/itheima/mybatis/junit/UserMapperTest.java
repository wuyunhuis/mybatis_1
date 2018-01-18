package cn.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.entity.User;
import cn.itheima.mybatis.mapping.UserMapper;

public class UserMapperTest {
	@Test
    public void testUserMapper() throws IOException{
    	String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		User user=userMapper.findUserById(1);
		System.out.println(user);
    }
	 
}

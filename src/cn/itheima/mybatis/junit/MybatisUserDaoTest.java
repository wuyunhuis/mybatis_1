package cn.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itheima.mybatis.dao.UserDao;
import cn.itheima.mybatis.dao.impl.UserDaoImpl;
import cn.itheima.mybatis.entity.User;

public class MybatisUserDaoTest {
    public SqlSessionFactory sqlSessionFactory;
     
    @Before
    public void before() throws IOException{
    	String resource="sqlMapConfig.xml";
    	InputStream in=Resources.getResourceAsStream(resource);
    	sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void testFindUserById(){
    	UserDao userDao=new UserDaoImpl(sqlSessionFactory);
    	SqlSession sqlSession=sqlSessionFactory.openSession();
    	 User user=userDao.findUserById(30);
    	 System.out.println(user);
    }
}

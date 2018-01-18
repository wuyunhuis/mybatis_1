package cn.itheima.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itheima.mybatis.entity.User;





public class UserMybatisTest {
	@Test
	public void testMybatis() throws Exception {
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行Sql语句 
		User user = sqlSession.selectOne("test.findUserById", 10);
		
		System.out.println(user);
		 
	}
	@Test
	public void testFindByName() throws Exception{
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<User> user=sqlSession.selectList("test.findUserName","五");
		for (User user2 : user) {
			System.out.println(user2);
		}
	}
	//添加用户并且显示id
	@Test
	public void testInsertUser() throws Exception{
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=new User();
		user.setUsername("肥哥");
		Date date=new Date();
		user.setBirthday(date);
		user.setSex("男");
		user.setAddress("广西来宾");
		int i=sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	@Test
	public void testUpdateUser() throws Exception{
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=new User();
		user.setId(29);
		user.setUsername("肥哥1212");
		Date date=new Date();
		user.setBirthday(date);
		user.setSex("男");
		user.setAddress("广西");
		int i=sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	@Test
	public void testDeleteUser() throws Exception{
		String resource="sqlMapConfig.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user=new User();
		user.setId(29);
		user.setUsername("肥哥1212");
		Date date=new Date();
		user.setBirthday(date);
		user.setSex("男");
		user.setAddress("广西");
		int i=sqlSession.delete("test.deleteUserById", 29);
		sqlSession.commit();
		System.out.println(user.getId());
	}
}

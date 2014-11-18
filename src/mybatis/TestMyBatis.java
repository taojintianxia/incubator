package mybatis;

import java.io.IOException;
import java.util.List;

import mybatis.pojo.User;
import mybatis.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMyBatis {

	public static SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSessionFactory();

	public static void main(String... args) throws IOException {
		TestMyBatis test = new TestMyBatis();
		test.testGet();
	}

	@Test
	public void testGet() {
		String statement = "mybatis.config.userMapper.getUser";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(statement, 2);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testGetAll() {
		String statement = "mybatis.config.userMapper.getAllUsers";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList(statement);
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testAdd() {
		User user = new User(-1, "Jim", 14);
		String statement = "mybatis.config.userMapper.addUser";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert(statement, user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdate() {
		User user = new User(2, "Kane", 30);
		String statement = "mybatis.config.userMapper.updateUser";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update(statement, user);
		sqlSession.commit();
		sqlSession.close();
	}

	public void testDelete() {
		String statement = "mybatis.config.userMapper.deleteUser";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete(statement, 1);
		sqlSession.commit();
		sqlSession.close();
	}
}

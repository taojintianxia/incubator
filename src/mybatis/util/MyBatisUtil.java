package mybatis.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	public static SqlSessionFactory getSessionFactory() {
		String resource = "mybatis/config/conf.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// lazy to handle.
			e.printStackTrace();
		}
		// InputStream confIS =
		// Test.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
		return sqlFactory;
	}

}

package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("resource")

public class JavaTest {

	private static Logger logger = LoggerFactory.getLogger(JavaTest.class);
	private static Random random = new Random();
	private static long USER_NUM = 10000000;
	private static File file = new File("/Users/kane/Desktop/trans.txt");

	public static void main(String... args) throws IOException {
		JavaTest javaTest = new JavaTest();
		javaTest.writeFile(file);
		javaTest.readFile(file);
		String json = "{\"amount\":442,\"apiUser\":646,\"transType\":171,\"userId\":1500272185267068690}";
		TransactionUser user = JSON.parseObject(json, TransactionUser.class);
		logger.info(user.toString());
	}

	public void writeFile(File file) throws IOException {
		TransactionUser user = new TransactionUser();
		FileWriter fileWriter = new FileWriter(file);
		long timeStart = System.currentTimeMillis();

		for (int i = 0; i < USER_NUM; i++) {
			user.setUserId(Math.abs(random.nextLong()) + 1);
			user.setApiUser(random.nextInt(1000) + 1);
			user.setAmount(new BigDecimal(random.nextInt(1000) + 1));
			user.setTransType((short) (random.nextInt(255) + 1));
			fileWriter.write(JSON.toJSONString(user) + "\n");
		}

		fileWriter.flush();

		System.out.println("共用时" + (System.currentTimeMillis() - timeStart) / 1000 + "秒");
	}

	public void readFile(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		long timeStart = System.currentTimeMillis();
		List<TransactionUser> userList = new ArrayList<>();

		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = bufferedReader.readLine();
		System.out.println("line is : " + line);
		while (line != null) {
			TransactionUser user = JSON.parseObject(line.trim(), TransactionUser.class);
			userList.add(user);
			line = bufferedReader.readLine();
		}
		logger.info(userList.get(0).toString());
		logger.info("共用时" + (System.currentTimeMillis() - timeStart) / 1000 + "秒");
	}

}

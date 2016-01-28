package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaTest {
	public static String sql = "ALTER TABLE `money_record_#` MODIFY COLUMN `id`  bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT FIRST , MODIFY COLUMN `money_record_id`  bigint(20) NOT NULL AFTER `id`;";

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM");

	public static void main(String... args) {
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();

		startTime.set(Calendar.YEAR, 2013);
		startTime.set(Calendar.MONTH, 0);

		endTime.set(Calendar.YEAR, 2017);
		endTime.set(Calendar.MONTH, 12);

		while (startTime.before(endTime)) {
			System.out.println(sql.replace("#", simpleDateFormat.format(startTime.getTime())));
			startTime.add(Calendar.MONTH, 1);
		}
	}
}

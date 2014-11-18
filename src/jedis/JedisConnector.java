package jedis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 *
 *
 * @author Kane.Sun
 * @version May 12, 2014 4:00:29 PM
 * 
 */

public class JedisConnector {
	public static void main(String... args) {
		Jedis redis = new Jedis("192.168.96.135", 6379);

		Set keys = redis.keys("*");
		Iterator t1 = keys.iterator();
		while (t1.hasNext()) {
			Object obj1 = t1.next();
			System.out.println(obj1);
		}
	}
}

package httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class GetMethodDemo {

	@Test
	public void testGetMethod() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet("http://www.yooli.com/");
		System.out.println("executing request " + httpget.getURI());
		// 执行get请求.
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			System.out.println("--------------------------------------");
			// 打印响应状态
			System.out.println(response.getStatusLine());
			if (entity != null) {
				// 打印响应内容长度
				System.out.println("Response content length: " + entity.getContentLength());
				// 打印响应内容
				System.out.println("Response content: " + EntityUtils.toString(entity));
			}
			System.out.println("------------------------------------");
		} finally {
			response.close();
		}
	}

}

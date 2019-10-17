package com.timerbox.cloud.serviceadminserver.utils;

import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * http网络请求处理工具类
 * @author TanJin   //TODO 每个类型的请求参数不同，所以才搞了不同的HttpClientUtils
 * date 2016-8-14
 */
public class HttpClientUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * post请求
	 * 
	 * @param url
	 * @param reqEntity
	 * @param headers
	 * @return byte[]
	 * @date 2016-8-14
	 */
	public static byte[] doPost(String url, HttpEntity reqEntity, Header[] headers) throws IOException {
		CloseableHttpResponse response = null;
		long startTime = System.currentTimeMillis();
		int status = 0;
		try {
			logger.info("post start url:{}", url);
			CloseableHttpClient client = HttpClientManager.getInstance().getHttpClient();
			HttpPost request = new HttpPost(url);
			if (headers != null) {
				request.setHeaders(headers);
			}
			request.setConfig(RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(10000).build());
			request.setEntity(reqEntity);
			response = client.execute(request, new BasicHttpContext());
			status = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == status || HttpStatus.SC_PARTIAL_CONTENT == status) {
				return EntityUtils.toByteArray(response.getEntity());
			} else {
				throw new RuntimeException("receive code:" + status);
			}
		} finally {
			long endTime = System.currentTimeMillis();
			logger.info("post end url:{} time:{}", url, System.currentTimeMillis() - startTime);
			// MonitorService.getInstance().putHttpClient(0L, url, startTime,
			// endTime, null, null, status);
			if (response != null) {
				response.close();
			}
		}
	}

	public static String doPostString(String url, HttpEntity reqEntity, Header[] headers) throws Exception {
		byte[] result = doPost(url, reqEntity, headers);
		return new String(result);
	}

	public static String doPostString(String url, JSON json, Header[] headers) {
		HttpEntity reqEntity = null;
		if (json != null) {
			reqEntity = new ByteArrayEntity(json.toString().getBytes());
		}
		try {
			return HttpClientUtils.doPostString(url, reqEntity, headers);
		} catch (Exception e) {
			logger.error("", e);
			return null;
		}
	}

	public static JSON doPost(String url, JSON json, Header[] headers) throws Exception {
		String result = doPostString(url, json, headers);
		return JSON.parseObject(result);
	}

	/**
	 * get请求
	 * 
	 * @date 2016-8-14
	 */
	public static byte[] doGet(String url, Header[] headers) throws IOException {
		CloseableHttpResponse response = null;
		long startTime = System.currentTimeMillis();
		int status = 0;
		try {
			logger.info("get start url:{}", url);
			CloseableHttpClient client = HttpClientManager.getInstance().getHttpClient();
			HttpGet request = new HttpGet(url);

			if (headers != null) {
				request.setHeaders(headers);
			}
			response = client.execute(request, new BasicHttpContext());
			status = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == status || HttpStatus.SC_PARTIAL_CONTENT == status) {
				return EntityUtils.toByteArray(response.getEntity());
			} else {
				throw new RuntimeException("receive code:" + status);
			}
		} finally {
			long endTime = System.currentTimeMillis();
			logger.info("get end url:{} time:{}", url, endTime - startTime);
			if (response != null) {
				response.close();
			}
			// MonitorService.getInstance().putHttpClient(0, url, startTime,
			// endTime, null, null, status);
		}
	}

	public static String doGetToString(String url, Header[] headers) throws IOException {
		byte[] result = doGet(url, headers);
		return new String(result);
	}

	public static JSON doGetToJson(String url, Header[] headers) throws Exception {
		String result = doGetToString(url, headers);
		return JSON.parseObject(result);
	}
}

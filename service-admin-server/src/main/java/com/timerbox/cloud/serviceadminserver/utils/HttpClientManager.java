package com.timerbox.cloud.serviceadminserver.utils;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.pool.PoolStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * httpClient manager.
 * @author Bruce Li
 *
 */
public class HttpClientManager {
	private Logger log = LoggerFactory.getLogger(HttpClientManager.class);
	private static HttpClientManager instance;
	private PoolingHttpClientConnectionManager httpClientManager = null;
	private RequestConfig requestConfig = null;
	private CloseableHttpClient httpClient = null;

	private HttpClientManager(){
		int timeout = 5000;
		httpClientManager = new PoolingHttpClientConnectionManager();
		httpClientManager.setMaxTotal(1024);
		httpClientManager.setDefaultMaxPerRoute(1024);
		requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
		httpClient = HttpClients.custom().setConnectionManager(httpClientManager).setDefaultRequestConfig(requestConfig).build();
	}

	public static synchronized HttpClientManager getInstance(){
		if(instance==null){
			instance = new HttpClientManager();
		}
		return instance;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void printStatus(){
		PoolStats status = httpClientManager.getTotalStats();
		log.info("[AVAILABLE:{}] [LEASED:{}] [MAX:{}] [PENDING:{}]", new Object[]{status.getAvailable(), status.getLeased(), status.getMax(), status.getPending()});
	}
}

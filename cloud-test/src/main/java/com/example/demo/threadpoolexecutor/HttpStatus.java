package com.example.demo.threadpoolexecutor;

/**
 * HTTP 返回的状态
 * @author xuliang
 *
 */
public enum HttpStatus {
	
	/**
	 * 成功
	 */
	success(206),
	
	/**
	 * 拒绝访问
	 */
	forbit(403),
	
	/**
	 * 未知错误
	 */
	error_unknown(500),
	
	/**
	 * session失效
	 */
	error_session_expire(501),
	
	/**
	 * 不支持的协议
	 */
	error_not_support_protocol(502),
	
	/**
	 * 没有读取到请求的数据
	 */
	error_no_data(503),
	
	/**
	 * 请求的长度不对
	 */
	error_data_length_not_right(504),
	
	/**
	 * 服务器限流
	 */
	error_throttling(505),

	/**
	 * 第三方服务器不可用
	 */
	error_third_service_unavailable(506)
	;
	
	private int status;
	HttpStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
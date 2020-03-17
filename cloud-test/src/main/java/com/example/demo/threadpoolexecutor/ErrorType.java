package com.example.demo.threadpoolexecutor;

/**
 * 错误类型
 * @author xuliang
 *
 */
public enum ErrorType {
	/**
	 * Session 失效
	 */
	session_expires,
	
	/**
	 * 稍后再发送
	 */
	later,
	
	/**
	 * 服务器错误
	 */
	server_error,
	
	/**
	 * 请求的数据不存在
	 */
	not_found,
	
	/**
	 * 没有权限
	 */
	no_privilege,
	/**
	 * 未认证
	 */
	unauthorized,
	/**
	 * 认证信息审核中
	 */
	reviewing,
	/**
	 * 老板开除了秘书
	 */
	fired,
	/**
	 * 认证信息被拒绝
	 */
	rejected,
	
	/**
	 * 多企业模式下，企业已解散
	 */
	corp_closed,
	
	/**
	 * 多企业模式下，需要先加入企业才可以继续
	 */
	need_join_corp,
	
	/**
	 * 多企业模式下，需要切换企业
	 */
	need_switch_to_corp,
	
	/**
	 * token过期
	 */
	token_expires,
	
	/**
	 * 需要完善信息
	 */
	need_complete_info,
	/**
	 * 用户被移出企业
	 */
	removed_from_corp;
}

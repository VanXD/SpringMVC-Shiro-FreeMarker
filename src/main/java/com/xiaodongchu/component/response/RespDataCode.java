package com.xiaodongchu.component.response;

/**
 * 与数据有关的枚举定义.
 *
 * @author liuyu
 * @since 2014年11月14日
 */
public enum RespDataCode {
	
	// 验证验证码
	/** The check code fail. */
	CHECK_CODE_FAIL(102, "验证验证码失败"),
	
	/** The check code none. */
	CHECK_CODE_NONE(103, "输入验证码为空"),
	
	/** The get code none. */
	GET_CODE_NONE(104, "获取系统保存验证码为空"),
	
	// 用户
	/** The user registed. */
	USER_REGISTED(201, "用户已经存在"),
	
	/** The user not exist. */
	USER_NOT_EXIST(202, "用户不存在"),
	
	/** The signed. */
	SIGNED(203, "用户已签到"),
	
	/** The unsign. */
	UNSIGN(204, "用户未签到"),
	
	/** The user pass error. */
	USER_PASS_ERROR(205, "用户密码错误"),
	
	/** The user name none. */
	USER_NAME_NONE(206, "用户名为空"),
	
	/** The user pass none. */
	USER_PASS_NONE(207, "用户密码为空"),
	
	/** The user lock. */
	USER_LOCK(209, "用户已被冻结"),
	
	/** The user del. */
	USER_DEL(210, "用户已被删除"),
	
	/** The user fullname use. */
	USER_FULLNAME_USE(211, "用户呢称已存在"),

	USER_ROLE_CHOOSE(212, "请选择角色！"),

	PRODUCT_SAVE_FAIL(301, "商品保存失败！"),

	PRODUCT_UDPATE_FAIL(301, "商品修改失败！"),

	PRODUCT_DELETE_FAIL(301, "商品删除失败！");

	
	
	/** 响应代码. */
	private int code;
	
	/** 响应含义. */
	private String meaning;
	
	/**
	 * Instantiates a new resp data code.
	 *
	 * @param code
	 *            the code
	 * @param meaning
	 *            the meaning
	 */
	private RespDataCode(int code, String meaning){
		this.code = code;
		this.meaning = meaning;
	}
	
	/**
	 * 获取对应的响应代码.
	 *
	 * @return the 响应代码
	 */
	public int getCode(){
		return this.code;
	}
	
	/**
	 * 获取对应的响应代码含义.
	 *
	 * @return the 响应含义
	 */
	public String getMeaning(){
		return this.meaning;
	}
	
}

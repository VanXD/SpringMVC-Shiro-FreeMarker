package com.xiaodongchu.component.response;

/**
 * 响应代码枚举定义.
 */
public enum RespCode {
	
	/** The success. */
	SUCCESS(0, "成功"),
	
	/** The fail. */
	FAIL(-1, "请求数据失败"),
	
	/** The save success. */
	SAVE_SUCCESS(200, "保存成功"),
	
	/** The param invalid. */
	PARAM_INVALID(300, "参数无效"),
	
	/** The no data. */
	NO_DATA(400, "未找到数据"),
	
	/** The illegal. */
	ILLEGAL(500, "参数非法"),
	
	/** The runtime err. */
	RUNTIME_ERR(600, "未知错误"),
	
	/** The auth failure. */
	AUTH_FAILURE(2001, "鉴权失败");
	
	
	/** 响应代码. */
	private int code;
	
	/** 响应含义. */
	private String meaning;
	
	/**
	 * Instantiates a new resp code.
	 *
	 * @param code
	 *            the code
	 * @param meaning
	 *            the meaning
	 */
	private RespCode(int code, String meaning){
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

package com.cldt.base.exception;


import com.cldt.base.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务异常.
 *
 * @zhoukj
 */
@Slf4j
public class BusinessException extends RuntimeException {

	/**
	 * 异常码
	 */
	protected int code;

	private static final long serialVersionUID = 3160241586346324994L;

	public BusinessException() {
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}

	public BusinessException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
	}

	public BusinessException(ErrorCodeEnum codeEnum, Object... args) {
		super(String.format(codeEnum.msg(), args));
		this.code = codeEnum.code();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}

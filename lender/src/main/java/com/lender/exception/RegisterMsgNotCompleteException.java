package com.lender.exception;

/**
 * 注册信息不完整异常
 * 
 * @author Administrator
 *
 */
public class RegisterMsgNotCompleteException extends RegisterException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public RegisterMsgNotCompleteException(String exceptionCode, String excetpionMsg) {
	super(exceptionCode, excetpionMsg);
	// TODO Auto-generated constructor stub
    }

}

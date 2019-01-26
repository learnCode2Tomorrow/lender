package com.lender.exception;

public class RegisterException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String exceptionCode;
    private String excetpionMsg;

    public String getExceptionCode() {
	return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
	this.exceptionCode = exceptionCode;
    }

    public String getExcetpionMsg() {
	return excetpionMsg;
    }

    public void setExcetpionMsg(String excetpionMsg) {
	this.excetpionMsg = excetpionMsg;
    }

    /**
     * @param exceptionCode
     * @param excetpionMsg
     */
    public RegisterException(String exceptionCode, String excetpionMsg) {
	super();
	this.exceptionCode = exceptionCode;
	this.excetpionMsg = excetpionMsg;
    }

}

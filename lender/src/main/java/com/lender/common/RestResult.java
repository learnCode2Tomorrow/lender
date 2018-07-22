package com.lender.common;

/**
 * 
 * @author q1238
 *
 * @param <E>
 */
public class RestResult<E>
{
	private boolean result;
	private E resultMessage;
	private E resultCode;
	private E resultData;

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public E getResultMessage()
	{
		return resultMessage;
	}

	public void setResultMessage(E resultMessage)
	{
		this.resultMessage = resultMessage;
	}

	public E getResultCode()
	{
		return resultCode;
	}

	public void setResultCode(E resultCode)
	{
		this.resultCode = resultCode;
	}

	public E getResultData()
	{
		return resultData;
	}

	public void setResultData(E resultData)
	{
		this.resultData = resultData;
	}

}

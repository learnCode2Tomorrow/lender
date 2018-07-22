package exception;

public class RegisterInfoNotCompleteException extends Exception
{

	private static final long serialVersionUID = 1L;

	public RegisterInfoNotCompleteException()
	{
		super();
	}

	public RegisterInfoNotCompleteException(String message)
	{
		super(message);
	}
}

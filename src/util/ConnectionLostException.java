package util;

public class ConnectionLostException extends RuntimeException {

	private static final long serialVersionUID = 4493418404285571360L;

	public ConnectionLostException(Exception e){
		super(e);
	}
}

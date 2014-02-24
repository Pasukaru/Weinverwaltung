package integration;
import util.ExceptionHandler;
import static org.junit.Assert.*;

public class TestExceptionHandler implements ExceptionHandler {

	@Override
	public void handleException(Exception e) {
		e.printStackTrace();
		fail("An exception occured! "+e.getMessage());
	}

}

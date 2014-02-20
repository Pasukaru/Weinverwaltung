package util;

public class SplashMessage {

	private static final String[] messages = {
		"Korken ziehen...",
		"Weintrauben stampfen...",
		"Preise ausw�rfeln...",
		"Weinproben organisieren...",
		"Flaschen sch�tteln...",
		"Sommeliers bestechen...",
		"Wein des Jahres mixen..."
	};
	
	public static String getRandom(){
		return messages[(int)Math.floor(Math.random()*messages.length)];
	}
}

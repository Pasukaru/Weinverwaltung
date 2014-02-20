package util;

public class SplashMessage {

	private static final String[] messages = {
		"Flaschen sch�tteln...",
		"Korken ziehen...",
		"Weintrauben stampfen...",
		"Preise ausw�rfeln...",
		"Weinproben organisieren...",
		"Sommeliers bestechen...",
		"Wein des Jahres mixen...",
		"F�sser sortieren...",
	};
	
	private static int next = (int) Math.floor(Math.random()*messages.length);
	
	public static String getNext(){
		if(next == messages.length){ next = 0; }
		return messages[next++];
	}
}

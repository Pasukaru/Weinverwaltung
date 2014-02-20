package util;

public class SplashMessage {

	private static final String[] messages = {
		"Flaschen schütteln...",
		"Korken ziehen...",
		"Weintrauben stampfen...",
		"Preise auswürfeln...",
		"Weinproben organisieren...",
		"Sommeliers bestechen...",
		"Wein des Jahres mixen...",
		"Fässer sortieren...",
	};
	
	private static int next = (int) Math.floor(Math.random()*messages.length);
	
	public static String getNext(){
		if(next == messages.length){ next = 0; }
		return messages[next++];
	}
}

package util;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public final class StringUtils {

	private StringUtils(){}
	
	public static String join(List<String> strings, String delimiter){
		StringBuffer sb = new StringBuffer();
		if(!strings.isEmpty()){
			sb.append(strings.get(0));
			for(int i=1, n=strings.size(); i<n ; i++){
				sb.append(delimiter);
				sb.append(strings.get(i));
			}
		}
		return sb.toString();
	}
	
	public static String formatCurrency(double value){
		Locale locale = new Locale("de", "DE");
		NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
		return fmt.format(value);
	}
	
	public static String formatPrice(int value){
		return StringUtils.formatCurrency(value/100d);
	}
}

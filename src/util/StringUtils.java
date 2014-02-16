package util;

import java.util.List;

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
}

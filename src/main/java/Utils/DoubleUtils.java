package Utils;

import org.apache.commons.lang3.math.NumberUtils;

public class DoubleUtils {
	
	public static double parse(String valeur) {
		
		if (valeur.isEmpty()) {
			return 0.0;
		} else if (!NumberUtils.isDigits(valeur)){
			return 0.0;
		} else {
			return Double.parseDouble(valeur);
		}
	}

}

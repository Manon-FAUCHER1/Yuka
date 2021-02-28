package Utils;

import org.apache.commons.lang3.math.NumberUtils;

import Exceptions.ExceptionMessage;

public class DoubleUtils {
	
	public static double parse(String valeur) throws ExceptionMessage {
		
		if (valeur.isEmpty()) {
			return 0.0;
		} else if (!NumberUtils.isDigits(valeur) || valeur.length() > 255){
			throw new ExceptionMessage("La valeur n'est pas correcte.");
		} else {
			return Double.parseDouble(valeur);
		}
	}

}

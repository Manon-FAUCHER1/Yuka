package Utils;

public class DoubleUtils {
	
	public static double parse(String valeur) {
		
		if (valeur.isEmpty()) {
			return 0.0;
		} else {
			return Double.parseDouble(valeur);
		}
	}

}

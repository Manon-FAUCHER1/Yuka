/**
 * 
 */
package Utils;

import Exceptions.ExceptionMessage;

/**
 * @author manon
 *
 */
public class VerifUtil {


	public static String verifString(String valeur) {
		
		if (valeur.isEmpty()) {
			return " ";
		} else {
			return valeur;
		}

	}
	

}

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

	/**
	 * @param args
	 * @throws ExceptionMessage 
	 */
	public static String verifString(String valeur) {
		
		if (valeur.isEmpty()) {
			return " ";
		} else {
			return valeur;
		}
		

	}

}

/**
 * 
 */
package Entities;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author manon
 *
 */
public enum NutritionGradeFr {
	
	a("a"),
	b("b"),
	c("c"),
	d("d"),
	e("e"),
	f("f");
	
	private String nutritionGradeFr;
	
	/**
	 * Constructor
	 */
	private NutritionGradeFr() {}
	

	/**
	 * Constructor
	 * @param nutritionGradeFr
	 */
	private NutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}
	
	public static boolean contains(String valeur) {

	    for (NutritionGradeFr c : NutritionGradeFr.values()) {
	        if (c.name().equals(valeur)) {
	            return true;
	        }
	    }

	    return false;
	}
}

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
@Embeddable
public enum NutritionGradeFr {
	
	a("a"),
	b("b"),
	c("c"),
	d("d"),
	e("e"),
	f("f");
	
	@Column(name = "NutritionGradeFr", nullable = false, length = 1)
	private String nutritionGradeFr;

	private NutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}

	public String getNutritionGradeFr() {
		return nutritionGradeFr;
	}

	public void setNutritionGradeFr(String nutritionGradeFr) {
		this.nutritionGradeFr = nutritionGradeFr;
	}
	
	public static boolean contains(String test) {

	    for (NutritionGradeFr c : NutritionGradeFr.values()) {
	        if (c.name().equals(test)) {
	            return true;
	        }
	    }

	    return false;
	}
}

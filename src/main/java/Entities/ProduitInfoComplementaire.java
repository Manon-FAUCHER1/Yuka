/**
 * 
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author manon
 *
 */
@Embeddable
public class ProduitInfoComplementaire {
	
	@Column(name = "vit_A_100g", nullable = true)
	private String vitA100g;
	
	@Column(name = "vitD100g", nullable = true)
	private String vitD100g;
	
	@Column(name = "vitE100g", nullable = true)
	private String vitE100g;
	
	@Column(name = "vitK100g", nullable = true)
	private String vitK100g;
	
	@Column(name = "vitC100g", nullable = true)
	private String vitC100g;
	
	@Column(name = "vitB1100g", nullable = true)
	private String vitB1100g;
	
	@Column(name = "vitB2100g", nullable = true)
	private String vitB2100g;
	
	@Column(name = "vitPP100g", nullable = true)
	private String vitPP100g;
	
	@Column(name = "vitB6100g", nullable = true)
	private String vitB6100g;
	
	@Column(name = "vitB9100g", nullable = true)
	private String vitB9100g;
	
	@Column(name = "vitB12100g", nullable = true)
	private String vitB12100g;
	
	@Column(name = "calcium100g", nullable = true)
	private String calcium100g;
	
	@Column(name = "magnesium100g", nullable = true)
	private String magnesium100g;
	
	@Column(name = "iron100g", nullable = true)
	private String iron100g;
	
	@Column(name = "fer100g", nullable = true)
	private String fer100g;
	
	@Column(name = "betaCarotene100g", nullable = true)
	private String betaCarotene100g;

	@Column(name = "presenceHuilePalme", nullable = true)
	private String presenceHuilePalme;

	/**
	 * Constructor
	 */
	public ProduitInfoComplementaire() {}

	public String getVitA100g() {
		return vitA100g;
	}

	public void setVitA100g(String vitA100g) {
		this.vitA100g = vitA100g;
	}

	public String getVitD100g() {
		return vitD100g;
	}

	public void setVitD100g(String vitD100g) {
		this.vitD100g = vitD100g;
	}

	public String getVitE100g() {
		return vitE100g;
	}

	public void setVitE100g(String vitE100g) {
		this.vitE100g = vitE100g;
	}

	public String getVitK100g() {
		return vitK100g;
	}

	public void setVitK100g(String vitK100g) {
		this.vitK100g = vitK100g;
	}

	public String getVitC100g() {
		return vitC100g;
	}

	public void setVitC100g(String vitC100g) {
		this.vitC100g = vitC100g;
	}

	public String getVitB1100g() {
		return vitB1100g;
	}

	public void setVitB1100g(String vitB1100g) {
		this.vitB1100g = vitB1100g;
	}

	public String getVitB2100g() {
		return vitB2100g;
	}

	public void setVitB2100g(String vitB2100g) {
		this.vitB2100g = vitB2100g;
	}

	public String getVitPP100g() {
		return vitPP100g;
	}

	public void setVitPP100g(String vitPP100g) {
		this.vitPP100g = vitPP100g;
	}

	public String getVitB6100g() {
		return vitB6100g;
	}

	public void setVitB6100g(String vitB6100g) {
		this.vitB6100g = vitB6100g;
	}

	public String getVitB9100g() {
		return vitB9100g;
	}

	public void setVitB9100g(String vitB9100g) {
		this.vitB9100g = vitB9100g;
	}

	public String getVitB12100g() {
		return vitB12100g;
	}

	public void setVitB12100g(String vitB12100g) {
		this.vitB12100g = vitB12100g;
	}

	public String getCalcium100g() {
		return calcium100g;
	}

	public void setCalcium100g(String calcium100g) {
		this.calcium100g = calcium100g;
	}

	public String getMagnesium100g() {
		return magnesium100g;
	}

	public void setMagnesium100g(String magnesium100g) {
		this.magnesium100g = magnesium100g;
	}

	public String getIron100g() {
		return iron100g;
	}

	public void setIron100g(String iron100g) {
		this.iron100g = iron100g;
	}

	public String getFer100g() {
		return fer100g;
	}

	public void setFer100g(String fer100g) {
		this.fer100g = fer100g;
	}

	public String getBetaCarotene100g() {
		return betaCarotene100g;
	}

	public void setBetaCarotene100g(String betaCarotene100g) {
		this.betaCarotene100g = betaCarotene100g;
	}

	public String getPresenceHuilePalme() {
		return presenceHuilePalme;
	}

	public void setPresenceHuilePalme(String presenceHuilePalme) {
		this.presenceHuilePalme = presenceHuilePalme;
	}

	@Override
	public String toString() {
		return "ProduitInfoComplementaire [vitA100g=" + vitA100g + ", vitD100g=" + vitD100g + ", vitE100g=" + vitE100g
				+ ", vitK100g=" + vitK100g + ", vitC100g=" + vitC100g + ", vitB1100g=" + vitB1100g + ", vitB2100g="
				+ vitB2100g + ", vitPP100g=" + vitPP100g + ", vitB6100g=" + vitB6100g + ", vitB9100g=" + vitB9100g
				+ ", vitB12100g=" + vitB12100g + ", calcium100g=" + calcium100g + ", magnesium100g=" + magnesium100g
				+ ", iron100g=" + iron100g + ", fer100g=" + fer100g + ", betaCarotene100g=" + betaCarotene100g
				+ ", presenceHuilePalme=" + presenceHuilePalme + "]";
	}

	
	

}

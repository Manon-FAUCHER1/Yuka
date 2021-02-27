/**
 * 
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.NutritionGradeFr;
import Entities.Produits;
import Exceptions.ExceptionMessage;
import Utils.DoubleUtils;

/**
 * @author manon
 *
 */
public class ProduitDao {

	/**
	 * @param args
	 * @throws ExceptionMessage 
	 */
	public static void insert(EntityManager em, String[] colonnes) throws ExceptionMessage {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Produits produit = new Produits();;
		
		String nomProduit = colonnes[2];
		if (nomProduit.length() <= 255) {
			produit.setNom(nomProduit);
		} else {
			throw new ExceptionMessage("Le nom du produit est trop grand.");
		}
		
		String nutritionGrade = colonnes[3];
		if (NutritionGradeFr.contains(nutritionGrade)) {
			NutritionGradeFr nutritionGradeFr = NutritionGradeFr.valueOf(nutritionGrade);
			produit.setNutritionGradeFr(nutritionGradeFr);
		}else {
			throw new ExceptionMessage("Le score nutritionnel renseigner n'est pas valide.");
		}

		Double energie100g = DoubleUtils.parse(colonnes[5]);	
		produit.setEnergie100g(energie100g);
		
		Double graisse100g = DoubleUtils.parse(colonnes[6]);	
		produit.setGraisse100g(graisse100g);
		
		Double sucres100g = DoubleUtils.parse(colonnes[7]);		
		produit.setSucres100g(sucres100g);
		
		Double fibres100g = DoubleUtils.parse(colonnes[8]);	
		produit.setFibres100g(fibres100g);
		
		Double proteines100g = DoubleUtils.parse(colonnes[9]);
		produit.setProteines100g(proteines100g);
		
		Double sel100g = DoubleUtils.parse(colonnes[10]);		 
		produit.setSel100g(sel100g);
		
		String vitA100g =  colonnes[11];
		String vitD100g = colonnes[12];
		String vitE100g = colonnes[13];
		String vitK100g = colonnes[14];
		String vitC100g = colonnes[15];
		String vitB1100g = colonnes[16];
		String vitB2100g = colonnes[17];
		String vitPP100g = colonnes[18];
		String vitB6100g = colonnes[19];
		String vitB9100g = colonnes[20];
		String vitB12100g = colonnes[21];
		String calcium100g = colonnes[22];
		String magnesium100g = colonnes[23];
		String iron100g = colonnes[24];
		String fer100g = colonnes[25];
		String betaCarotene100g = colonnes[26];
		String presenceHuilePalme = colonnes[27];
		
		em.persist(produit);
		transaction.commit();
		

	}

}

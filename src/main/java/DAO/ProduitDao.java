/**
 * 
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Produits;
import Utils.DoubleUtils;

/**
 * @author manon
 *
 */
public class ProduitDao {

	/**
	 * @param args
	 */
	public static void insert(EntityManager em, String[] colonnes) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Produits produit = new Produits();;
		
		String nomProduit 		= colonnes[2];
		if (nomProduit.length() <= 255) {
			produit.setNom(nomProduit);
		}
		
		String nutritionGradeFr = colonnes[3];
		Double energie100g 		= DoubleUtils.parse(colonnes[5]);
		Double graisse100g 		= DoubleUtils.parse(colonnes[6]);
		Double sucres100g 		= DoubleUtils.parse(colonnes[7]);
		Double fibres100g 		= DoubleUtils.parse(colonnes[8]);
		Double proteines100g 	= DoubleUtils.parse(colonnes[9]);
		Double sel100g 			= DoubleUtils.parse(colonnes[10]);
		
		
		
		 
		
		produit.setEnergie100g(energie100g);
		produit.setGraisse100g(graisse100g);
		produit.setSucres100g(sucres100g);
		produit.setFibres100g(fibres100g);
		produit.setProteines100g(proteines100g);
		produit.setSel100g(sel100g);
		produit.setNutritionGradeFr(nutritionGradeFr);
		
		em.persist(produit);
		transaction.commit();
		

	}

}

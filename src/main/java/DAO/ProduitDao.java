/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Categories;
import Entities.Ingredients;
import Entities.Marques;
import Entities.NutritionGradeFr;
import Entities.ProduitInfoComplementaire;
import Entities.Produits;
import Exceptions.ExceptionMessage;
import Utils.DoubleUtils;
import Utils.VerifUtil;

/**
 * @author manon
 *
 */
public class ProduitDao {

	/**
	 * @param em
	 * @param colonnes
	 * @param categorie
	 * @param marque
	 * @return
	 * @throws ExceptionMessage
	 */
	public static Produits insert(EntityManager em, String[] colonnes, Categories categorie, Marques marque) throws ExceptionMessage {
		
		Produits produit = new Produits();
		
		String nomProduit = VerifUtil.verifString(colonnes[2]);
		
		if (nomProduit.length() <= 255) {
			
			produit.setNom(nomProduit);
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
			
			
			String nutritionGrade = colonnes[3];
			if (NutritionGradeFr.contains(nutritionGrade)) {
				NutritionGradeFr nutritionGradeFr = NutritionGradeFr.valueOf(nutritionGrade);
				produit.setNutritionGradeFr(nutritionGradeFr);
			}
			
			
			ProduitInfoComplementaire produitInfoComplementaire = new ProduitInfoComplementaire();
			
			String vitA100g = VerifUtil.verifString(colonnes[11]);
			produitInfoComplementaire.setVitA100g(vitA100g);
			String vitD100g = VerifUtil.verifString(colonnes[12]);
			produitInfoComplementaire.setVitD100g(vitD100g);
			String vitE100g = VerifUtil.verifString(colonnes[13]);
			produitInfoComplementaire.setVitE100g(vitE100g);
			String vitK100g = VerifUtil.verifString(colonnes[14]);
			produitInfoComplementaire.setVitK100g(vitK100g);
			String vitC100g = VerifUtil.verifString(colonnes[15]);
			produitInfoComplementaire.setVitC100g(vitC100g);
			String vitB1100g = VerifUtil.verifString(colonnes[16]);
			produitInfoComplementaire.setVitB1100g(vitB1100g);
			String vitB2100g = VerifUtil.verifString(colonnes[17]);
			produitInfoComplementaire.setVitB2100g(vitB2100g);
			String vitPP100g = VerifUtil.verifString(colonnes[18]);
			produitInfoComplementaire.setVitPP100g(vitPP100g);
			String vitB6100g = VerifUtil.verifString(colonnes[19]);
			produitInfoComplementaire.setVitB6100g(vitB6100g);
			String vitB9100g = VerifUtil.verifString(colonnes[20]);
			produitInfoComplementaire.setVitB9100g(vitB9100g);
			String vitB12100g = VerifUtil.verifString(colonnes[21]);
			produitInfoComplementaire.setVitB12100g(vitB12100g);
			String calcium100g = VerifUtil.verifString(colonnes[22]);
			produitInfoComplementaire.setCalcium100g(calcium100g);
			String magnesium100g = VerifUtil.verifString(colonnes[23]);
			produitInfoComplementaire.setMagnesium100g(magnesium100g);
			String iron100g = VerifUtil.verifString(colonnes[24]);
			produitInfoComplementaire.setIron100g(iron100g);
			String fer100g = VerifUtil.verifString(colonnes[25]);
			produitInfoComplementaire.setFer100g(fer100g);
			String betaCarotene100g = VerifUtil.verifString(colonnes[26]);
			produitInfoComplementaire.setBetaCarotene100g(betaCarotene100g);
			String presenceHuilePalme = VerifUtil.verifString(colonnes[27]);
			produitInfoComplementaire.setPresenceHuilePalme(presenceHuilePalme);
			
			produit.setProduitInfoComplementaire(produitInfoComplementaire);
			
			produit.setCategorie(categorie);
			produit.setMarque(marque);
			
			TypedQuery<Produits> query = em.createQuery(
					"SELECT produits FROM Produits produits JOIN produits.marque marque WHERE produits.nom = ?1 AND marque.nom = ?2",
					Produits.class);
			query.setParameter(1, nomProduit);
			query.setParameter(2, marque.getNom());
			List<Produits> produit2 = query.getResultList();
			
			if (produit2.size() == 0) {
				
				em.persist(produit);
				
			}else {
				produit = produit2.get(0);
			}
			
			return produit;
		}else {
			return null;
		}
		
		
		
	}

}

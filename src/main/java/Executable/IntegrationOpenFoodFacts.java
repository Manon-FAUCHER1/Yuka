/**
 * 
 */
package Executable;


import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;

import entities.Categories;
import entities.Marques;
import entities.Produits;


/**
 * @author manon
 *
 */
public class IntegrationOpenFoodFacts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Yuka");
			EntityManager em = entityManagerFactory.createEntityManager();
			
			File file = new File("C:\\Users\\manon\\Documents\\2 - PROFESSIONNEL\\1 - FORMATIONS\\1 - DIGINAMIC\\2 - COURS & TP\\Workspace java\\Yuka\\src\\main\\ressources\\open-food-facts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");
			
			if (lignes == null) {
				System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
				System.exit(-1);
			}
			
			for (String ligne : lignes) {
				
				String[] colonnes = ligne.split("\\|");
				
				if (colonnes[0].matches("\\d+")) {
					
					String colIngredients = colonnes[4];
					String[] ingredientsNom = colIngredients.split(",");					
					
					String nomCategories = colonnes[0];
					String nomMarque 	 = colonnes[1];
					
					// Produits
					String nomProduit = colonnes[3];
					double energie100g = Double.parseDouble(colonnes[5]);
					double graisse100g = Double.parseDouble(colonnes[6]);
					double sucres100g = Double.parseDouble(colonnes[7]);
					double fibres100g = Double.parseDouble(colonnes[8]);
					double proteines100g = Double.parseDouble(colonnes[9]);
					double sel100g = Double.parseDouble(colonnes[10]);		
					
					Produits produit = new Produits();
					produit.setNom(nomProduit);
					produit.setEnergie100g(energie100g);
					produit.setGraisse100g(graisse100g);
					produit.setSucres100g(sucres100g);
					produit.setFibres100g(fibres100g);
					produit.setProteines100g(proteines100g);
					produit.setSel100g(sel100g);
					
					Categories categorie = new Categories();
					categorie.setNom(nomCategories);
					
					produit.setCategorie(categorie);
					
					Marques marque = new Marques();
					marque.setNom(nomMarque);
					
					produit.setMarque(marque);
					
					
					EntityTransaction transaction = em.getTransaction();
					transaction.begin();
					
					em.persist(produit);
					em.persist(categorie);
					em.persist(marque);
					
					transaction.commit();
					
				}

				
			}

			
		} catch (Exception e) {
			System.out.println("probleme");
		}

	}

}

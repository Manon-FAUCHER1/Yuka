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

import DAO.CategoriesDao;
import DAO.MarqueDao;
import DAO.ProduitDao;

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

			/////////// RECUPERATION DU FICHIER CSV ///////////
			File file = new File(
					"C:\\Users\\manon\\Documents\\2 - PROFESSIONNEL\\1 - FORMATIONS\\1 - DIGINAMIC\\2 - COURS & TP\\Workspace java\\Yuka\\src\\main\\ressources\\open-food-facts.csv");
			List<String> lignes = FileUtils.readLines(file, "UTF-8");

			if (lignes == null) {
				System.out.println("L'application doit s'arrétée en raison d'une erreur d'exécution.");
				System.exit(-1);
			}

			lignes.remove(0);

			int cpt = 1;

			for (String ligne : lignes) {

				System.out.println(cpt);

				/////////// SEPARATION DES COLONNES ///////////
				String[] colonnes = ligne.split("\\|", -1);

								
				CategoriesDao.insert(em , colonnes);
				MarqueDao.insert(em, colonnes);
//				ProduitDao.insert(em, colonnes);
				
		
//				produit.setCategorie(ca);;
//				produit.setMarque(marque);
				
//				
//				// INGREDIENT //
//				String[] ingredients = colonnes[4].split("[,;-]", -1);
//
//				for (String ingredient : ingredients) {
//
//					if (ingredient.length() <= 255) {
//
//						Ingredients ingred = null;
//
//						TypedQuery<Ingredients> query = em.createQuery(
//								"SELECT ingredient FROM Ingredients ingredient WHERE ingredient.nom = ?1",
//								Ingredients.class);
//						query.setParameter(1, ingredient);
//						List<Ingredients> ingred2 = query.getResultList();
//
//						System.out.println(ingredient);
//						if (ingred2.size() == 0) {
//							ingred = new Ingredients();
//							ingred.setNom(ingredient);
//							em.persist(ingred);
//						} else {
//							ingred = ingred2.get(0);
//						}
//						
//						produit.getIngredients().add(ingred);
//						
//					}
//				}
//
//				
//				
//				transaction.commit();
				cpt++;
			}

		} catch (Exception e) {
			System.out.println("probleme \n" + e.getMessage());
			e.printStackTrace();
		}

	}

}

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

import DAO.AdditifDao;
import DAO.AllergeneDao;
import DAO.CategoriesDao;
import DAO.IngredientDao;
import DAO.MarqueDao;
import DAO.ProduitDao;
import Entities.Additifs;
import Entities.Allergenes;
import Entities.Categories;
import Entities.Ingredients;
import Entities.Marques;
import Entities.Produits;

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

				Categories categorie = CategoriesDao.insert(em, colonnes);
				Marques marque = MarqueDao.insert(em, colonnes);
				Produits produits = ProduitDao.insert(em, colonnes, categorie, marque);
//				Ingredients ingredient = IngredientDao.insert(em, colonnes, produits);
				Allergenes allergene = AllergeneDao.insert(em, colonnes, produits);
				Additifs additif = AdditifDao.insert(em, colonnes, produits);

				cpt++;
			}

		} catch (Exception e) {
			System.err.println("probleme \n" + e.getMessage());
			e.printStackTrace();
		}

	}

}

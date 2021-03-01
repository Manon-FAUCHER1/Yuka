/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Ingredients;
import Entities.Produits;
import Exceptions.ExceptionMessage;

/**
 * @author manon
 *
 */
public class IngredientDao {

	/**
	 * @param args
	 */
	public static void insert(EntityManager em, String[] colonnes, Produits produit) {

		EntityTransaction transaction = em.getTransaction();

		String[] ingredients = colonnes[4].split("[,;-]", -1);

		for (String ingredient : ingredients) {

			if (ingredient.length() <= 255) {

				// TRANSFORMATION DE L'INGREDIENT :

				// Suppression des _
				ingredient = ingredient.replace("_", " ");
				ingredient = ingredient.trim().replace("\\s{2,}", " ").toLowerCase();

				if (!ingredient.trim().isEmpty()) {
					// Première lettre en Majuscule
					char[] char_ingredient = ingredient.toCharArray();
					char_ingredient[0] = Character.toUpperCase(char_ingredient[0]);
					ingredient = new String(char_ingredient);

					Ingredients ingred = null;

					TypedQuery<Ingredients> query = em.createQuery(
							"SELECT ingredient FROM Ingredients ingredient WHERE ingredient.nom = ?1",
							Ingredients.class);
					query.setParameter(1, ingredient);
					List<Ingredients> ingred2 = query.getResultList();

					if (ingred2.size() == 0) {
						transaction.begin();

						ingred = new Ingredients();
						ingred.setNom(ingredient);
						em.persist(ingred);
						transaction.commit();
					} else {
						ingred = ingred2.get(0);
					}

					produit.getIngredients().add(ingred);

				}
			}
		}

	}

}

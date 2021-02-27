/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Categories;
import Exceptions.ExceptionMessage;

/**
 * @author manon
 *
 */
public class CategoriesDao {


	public static void insert(EntityManager em, String[] colonnes) throws ExceptionMessage {
		EntityTransaction transaction = em.getTransaction();
		
		String nomCategorie = colonnes[0];
		
		
		if (nomCategorie.length() <= 255) {
			
			
			Categories categorie = null;

			TypedQuery<Categories> query = em.createQuery(
					"SELECT categories FROM Categories categories WHERE categories.nom = ?1",
					Categories.class);
			query.setParameter(1, nomCategorie);
			List<Categories> cat = query.getResultList();

			if (cat.size() == 0) {
				transaction.begin();
				
				categorie = new Categories();
				categorie.setNom(nomCategorie);
				
				em.persist(categorie);
				transaction.commit();
			} else {
				categorie = cat.get(0);
			}		
			
		} else {
			throw new ExceptionMessage("Le nom de la catégorie est trop grande.");
		}
		
		
	}

}

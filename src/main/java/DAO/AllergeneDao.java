/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Allergenes;
import Entities.Ingredients;
import Entities.Produits;

/**
 * @author manon
 *
 */
public class AllergeneDao {

	public static Allergenes insert(EntityManager em, String[] colonnes, Produits produits) {
		
		EntityTransaction transaction = em.getTransaction();
		
		String[] allergenes = colonnes[28].split("[,]", -1);
		
		for (String allergene : allergenes) {
			
			if (allergene.length() <= 255) {
				
				// TRANSFORMATION DE L'ALLERGENE :
				allergene = allergene.trim().replace("\\s{2,}", " ").toLowerCase();
				char[] char_allergene = allergene.toCharArray();
				char_allergene[0] = Character.toUpperCase(char_allergene[0]);
				allergene = new String(char_allergene);
				
				Allergenes allerg = null;
				
				TypedQuery<Allergenes> query = em.createQuery(
						"SELECT allergene FROM Allergenes allergene WHERE allergene.nom = ?1",
						Allergenes.class);
				query.setParameter(1, allergene);
				List<Allergenes> allerg2 = query.getResultList();
				
				if(allerg2.size() == 0) {
					transaction.begin();
					
					allerg = new Allergenes();
					allerg.setNom(allergene);
					em.persist(allerg);
					transaction.commit();					
				} else {
					allerg = allerg2.get(0);
				}
				
				produits.getAllergenes().add(allerg);
				
				return allerg;
			}
			
		}
		return null;
	}
 
}
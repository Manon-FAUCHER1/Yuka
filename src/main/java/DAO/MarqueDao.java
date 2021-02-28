/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Marques;
import Exceptions.ExceptionMessage;

/**
 * @author manon
 *
 */
public class MarqueDao {

	/**
	 * @throws ExceptionMessage 
	 * 
	 */
	public static Marques insert(EntityManager em, String[] colonnes) {
		EntityTransaction transaction = em.getTransaction();
		
		String nomMarque = colonnes[1];

		if (nomMarque.length() <= 255 ) {
			
			Marques marque = null;
			
			TypedQuery<Marques> query = em.createQuery(
					"SELECT marques FROM Marques marques WHERE marques.nom = ?1",
					Marques.class);
			query.setParameter(1, nomMarque);
			List<Marques> mar = query.getResultList();
			
			if (mar.size() == 0) {
				transaction.begin();
				
				marque = new Marques();
				marque.setNom(nomMarque);
				
				em.persist(marque);
				transaction.commit();
			}else {
				marque = mar.get(0);
			}
			
			return marque;
		}
		return null;
	}

}

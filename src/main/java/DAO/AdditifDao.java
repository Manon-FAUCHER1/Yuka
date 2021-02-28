/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Additifs;
import Entities.Produits;

/**
 * @author manon
 *
 */
public class AdditifDao {

	public static Additifs insert(EntityManager em, String[] colonnes, Produits produits) {
		
		EntityTransaction transaction = em.getTransaction();

		String[] additifs = colonnes[28].split("[,]", -1);

		for (String additif : additifs) {

			if (additif.length() <= 255) {

				// TRANSFORMATION DE L'ALLERGENE :
				additif = additif.trim().replace("\\s{2,}", " ").toLowerCase();
				char[] char_additif = additif.toCharArray();
				char_additif[0] = Character.toUpperCase(char_additif[0]);
				additif = new String(char_additif);

				Additifs addit = null;

				TypedQuery<Additifs> query = em.createQuery(
						"SELECT allergene FROM Allergenes allergene WHERE allergene.nom = ?1", 
						Additifs.class);
				query.setParameter(1, additif);
				List<Additifs> addit2 = query.getResultList();

				if (addit2.size() == 0) {
					transaction.begin();

					addit = new Additifs();
					addit.setNom(additif);
					em.persist(addit);
					transaction.commit();
				} else {
					addit = addit2.get(0);
				}

				produits.getAdditifs().add(addit);

				return addit;
			}

		}
		return null;
	}

}

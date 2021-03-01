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
import Utils.VerifUtil;

/**
 * @author manon
 *
 */
public class AdditifDao {

	/**
	 * @param em
	 * @param colonnes
	 * @param produits
	 * @return
	 */
	public static void insert(EntityManager em, String[] colonnes, Produits produits) {

		EntityTransaction transaction = em.getTransaction();

		String[] additifs = VerifUtil.verifString(colonnes[29]).split("[,]", -1);

		for (String additif : additifs) {

			if (additif.length() <= 255) {

				Additifs addit = null;

				TypedQuery<Additifs> query = em.createQuery(
						"SELECT additif FROM Additifs additif WHERE additif.nom = ?1", Additifs.class);
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

		
			}

		}
		
	}

}

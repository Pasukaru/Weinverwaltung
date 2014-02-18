package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * JPA Utilities
 */
public class JpaUtil {

	private static EntityManager em = null;
	private static EntityManagerFactory emf = null;
	private static String persistenceunit = null;

	public static void init(final String pu) {
		close();
		em = null;
		emf = null;
		persistenceunit = pu;
	}

	public static void close() {
		if (em != null) {
			em.close();
			em = null;
		}
		if (emf != null) {
			emf.close();
			emf = null;
		}
	}

	public static EntityManager getEM() {
		if (emf == null) {
			if (persistenceunit == null) {
				throw new RuntimeException("persistenceunit is null");
			}
			emf = Persistence.createEntityManagerFactory(persistenceunit);
		}
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	public static EntityTransaction getTx() {
		return getEM().getTransaction();
	}
}

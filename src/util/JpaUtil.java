package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * JPA Utilities
 */
public class JpaUtil {

	/** EntityManager */
	private static EntityManager em;

	/** EntityManagerFactory */
	private static EntityManagerFactory emf;

	/** persistence: Datenbank */
	private static String persistenceunit = null;

	/** soll geloggt werden? */
	public static boolean log = true;

	/** init: persistence name festlegen */
	public static void init(final String pu) {
		persistenceunit = pu;
	}

	/** close EntityManager ... */
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

	/** EntityManager erzeugen */
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

	/** Transaktion erzeugen */
	public static EntityTransaction getTx() {
		return getEM().getTransaction();
	}

}

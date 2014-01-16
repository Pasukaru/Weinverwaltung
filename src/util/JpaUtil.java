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

	/** Log ausgeben */
	public static void log(final String str) {
		if (log && str != null) {
			System.out.print("### ");
			System.out.println(str);
		}
	}

	/** init: persistence name festlegen */
	public static void init(final String pu) {
		persistenceunit = pu;
	}

	/** close EntityManager ... */
	public static void close() {
		if (em != null) {
			em.close();
			em = null;
			log("EntityManager geschlossen!");
		}
		if (emf != null) {
			emf.close();
			emf = null;
			log("EntityManagerFactory geschlossen!");
		}
	}

	/** EntityManager erzeugen */
	public static EntityManager getEM() {

		if (emf == null) {
			log("Erzeuge EntityManagerFactory...");
			if (persistenceunit == null) {
				log("persistenceunit nicht gesetzt");
				throw new RuntimeException("persistenceunit nicht gesetzt");
			}
			emf = Persistence.createEntityManagerFactory(persistenceunit);
			log("EntityManagerFactory erzeugt!");
		}

		if (em == null) {
			em = emf.createEntityManager();
			log("EntityManager erzeugt!");
		}

		return em;
	}

	/** Transaktion erzeugen */
	public static EntityTransaction getTx() {
		log("Transaktion erzeugt!");
		return getEM().getTransaction();
	}

}

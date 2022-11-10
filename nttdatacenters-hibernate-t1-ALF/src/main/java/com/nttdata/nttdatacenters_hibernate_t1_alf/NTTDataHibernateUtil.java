package com.nttdata.nttdatacenters_hibernate_t1_alf;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Clase de configuración
 * 
 * @author ALF
 *
 */
public class NTTDataHibernateUtil {

	/** LOGGER */
	static final Logger log = LoggerFactory.getLogger(NTTDataHibernateUtil.class);

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/** Constructor privado */
	private NTTDataHibernateUtil() {

	}

	static {

		try {

			// Generación de la configuración
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {

			// Error de inicialización
			log.error(String.format("[ERROR] Configuración de Hibernate - %s", ex));
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Devuelve la factoría de sesiones
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}

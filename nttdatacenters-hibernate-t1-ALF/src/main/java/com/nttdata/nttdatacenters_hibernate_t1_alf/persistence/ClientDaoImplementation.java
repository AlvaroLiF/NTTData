package com.nttdata.nttdatacenters_hibernate_t1_alf.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Implementación del DAO de tabla NTTDATA_CLIENT
 * 
 * @author ALF
 *
 */
public class ClientDaoImplementation extends CommonDaoImplementation<Client> implements ClientDaoInterface {

	/** Sesión de conexión a BD */
	private Session session;

	/** Método constructor */
	public ClientDaoImplementation(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Constante con el inicio de la consulta en la tabla client buscando por el
	 * firstName
	 */
	static final String NAMEQUERY = "FROM Client WHERE firstName='";

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndIdentityCardNumber(String firstName, Integer identityCardNumber) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "' AND identityCardNumber=" + identityCardNumber).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstName(final String firstName) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstNameAndSurnames(String firstName, String firstSurname, String secondSurname) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "' AND firstSurname='" + firstSurname
				+ "' AND secondSurname='" + secondSurname + "'").list();
	}

}

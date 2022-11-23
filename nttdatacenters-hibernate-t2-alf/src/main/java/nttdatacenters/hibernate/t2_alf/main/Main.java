package nttdatacenters.hibernate.t2_alf.main;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters.hibernate.t2_alf.persistence.Client;
import nttdatacenters.hibernate.t2_alf.services.ClientManagementServiceImplementation;
import nttdatacenters.hibernate.t2_alf.services.ClientManagementServiceInterface;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * Clase principal
 * 
 * @author ALF
 *
 */
public class Main {

	/** LOGGER */
	static final Logger log = LoggerFactory.getLogger("Resultado");

	// Formato del cliente en el LOGGER
	static final String FORMATO = "| ID: %s | NOMBRE: %s | PRIMER APELLIDO: %s | SEGUNDO APELLIDO: %s | DNI: %s |";

	// Apertura de sesión
	static final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

	// Inicialización de servicios
	static final ClientManagementServiceInterface clientService = new ClientManagementServiceImplementation(session);

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Generación de clientes
		log.info("Creación de los clientes");

		final Client client1 = new Client();
		client1.setFirstName("Juan");
		client1.setFirstSurname("Álvarez");
		client1.setSecondSurname("Domínguez");
		client1.setIdentityCardNumber(242452525);

		final Client client2 = new Client();
		client2.setFirstName("Julian");
		client2.setFirstSurname("Muñoz");
		client2.setSecondSurname("Fernández");
		client2.setIdentityCardNumber(124534453);

		final Client client3 = new Client();
		client3.setFirstName("María");
		client3.setFirstSurname("Becerra");
		client3.setSecondSurname("Moreno");
		client3.setIdentityCardNumber(542976932);

		final Client client4 = new Client();
		client4.setFirstName("Jesús");
		client4.setFirstSurname("Pedrerol");
		client4.setSecondSurname("Ugarte");
		client4.setIdentityCardNumber(412231435);

		// Inserción de los clientes
		log.info("Inserción de los clientes");

		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		clientService.insertNewClient(client3);
		clientService.insertNewClient(client4);

		// Borrado del client1
		clientService.deleteClient(client1);

		// Actualización del nombre del client2
		client2.setFirstName("Marcos");
		clientService.updateClient(client2);

		// Se muestran todos los clientes
		searchAll();

		// Se muestran los clientes por nombre
		searchByFirstName("Marcos");

		// Se muestran los clientes por nombre y apellidos
		searchByFirstNameAndSurnames("María", "Becerra", "Moreno");

		// Se muestran los clientes por nombre y número de documento de identidad
		searchByFirstNameAndIdentityCardNumber("Jesús", 412231435);

	}

	/**
	 * Método que obtiene todos los clientes
	 */
	public static void searchAll() {

		try {

			List<Client> clients = clientService.searchAll();

			for (final Client client : clients) {

				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	/**
	 * Método que obtiene los clientes por el nombre
	 * 
	 * @param firstName
	 */
	public static void searchByFirstName(String firstName) {

		try {

			List<Client> clients = clientService.searchByFirstName(firstName);

			for (final Client client : clients) {

				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	/**
	 * Método que obtiene los clientes por el nombre y apellidos
	 * 
	 * @param firstName
	 * @param firstSurname
	 * @param secondSurname
	 */
	public static void searchByFirstNameAndSurnames(String firstName, String firstSurname, String secondSurname) {

		try {

			List<Client> clients = clientService.searchByFirstNameAndSurnames(firstName, firstSurname, secondSurname);

			for (final Client client : clients) {

				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	/**
	 * Método que obtiene los clientes por nombre y número del documento de
	 * identidad
	 * 
	 * @param firstName
	 * @param identityCardNumber
	 */
	public static void searchByFirstNameAndIdentityCardNumber(String firstName, Integer identityCardNumber) {

		try {

			List<Client> clients = clientService.searchByFirstNameAndIdentityCardNumber(firstName, identityCardNumber);

			for (final Client client : clients) {

				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

}

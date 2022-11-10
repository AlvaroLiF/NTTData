package com.nttdata.nttdatacenters_hibernate_t1_alf;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.Client;
import com.nttdata.nttdatacenters_hibernate_t1_alf.services.ClientManagementServiceImplementation;
import com.nttdata.nttdatacenters_hibernate_t1_alf.services.ClientManagementServiceInterface;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Clase principal
 * 
 * @author ALF
 *
 */
public class Main {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/** LOGGER */
		final Logger log = LoggerFactory.getLogger("Resultado");

		//
		final String FORMATO = "| ID: %s | NOMBRE: %s | PRIMER APELLIDO: %s | SEGUNDO APELLIDO: %s | DNI: %s |";

		// Apertura de sesión
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios
		final ClientManagementServiceInterface clientService = new ClientManagementServiceImplementation(session);

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

		// Búsqueda por el nombre

		try {
			List<Client> clients = clientService.searchByFirstName("Marcos");

			for (final Client client : clients) {
				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}

		// Búsqueda por nombre y apellidos

		try {
			List<Client> clients = clientService.searchByFirstNameAndSurnames("María", "Becerra", "Moreno");

			for (final Client client : clients) {
				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}

		// Búsqueda por nombre y número del documento de identidad

		try {
			List<Client> clients = clientService.searchByNameAndIdentityCardNumber("Jesús", 412231435);
			for (final Client client : clients) {
				if (log.isInfoEnabled()) {
					log.info(String.format(FORMATO, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}
		} finally {

			// Cierre de sesión
			session.close();
		}

	}
}

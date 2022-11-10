package com.nttdata.nttdatacenters_hibernate_t1_alf;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.LoggerFactory;

import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.Client;
import com.nttdata.nttdatacenters_hibernate_t1_alf.services.ClientManagementServiceImplementation;
import com.nttdata.nttdatacenters_hibernate_t1_alf.services.ClientManagementServiceInterface;

import ch.qos.logback.classic.Logger;

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
		final Logger log = (Logger) LoggerFactory.getLogger(Main.class);

		// Apertura de sesión
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios
		final ClientManagementServiceInterface clientService = new ClientManagementServiceImplementation(session);

		// Generación de clientes
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
		
		// Inserción de los clientes
		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		clientService.insertNewClient(client3);
		
		
		
		List<Client> clients = clientService.searchAll();

		for (final Client client : clients) {
			if (log.isInfoEnabled()) {
				log.info(String.format("%s | %s | %s | %s | %s", client.getClientId(), client.getFirstName(),
						client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
			}
		}
		
		clientService.searchByFirstName("Julian");
		clientService.searchByFirstNameAndSurnames("María", "Becerra", "Moreno");
		clientService.searchByNameAndIdentityCardNumber("Juan", 242452525);
		
		session.close();
	}
}

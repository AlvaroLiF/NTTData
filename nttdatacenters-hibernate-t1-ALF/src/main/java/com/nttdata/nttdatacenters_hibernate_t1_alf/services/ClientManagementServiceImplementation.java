package com.nttdata.nttdatacenters_hibernate_t1_alf.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.Client;
import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.ClientDaoImplementation;
import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.ClientDaoInterface;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Interfaz del servicio de clientes
 * 
 * @author ALF
 *
 */
public class ClientManagementServiceImplementation implements ClientManagementServiceInterface {

	/** DAO: NTTDATA_CLIENT */
	private ClientDaoInterface clientDao;

	/** Método constructor */
	public ClientManagementServiceImplementation(final Session session) {
		this.clientDao = new ClientDaoImplementation(session);
	}

	@Override
	public void insertNewClient(final Client newClient) {

		// Verificación de nulidad e inexistencia
		if (newClient != null && newClient.getClientId() == null) {

			// Inserción del nuevo cliente
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updateClient(final Client updatedClient) {

		// Verificación de nulidad e inexistencia
		if (updatedClient != null && updatedClient.getClientId() != null) {

			// Actualización del cliente
			clientDao.update(updatedClient);
		}

	}

	@Override
	public void deleteClient(final Client deletedClient) {

		// Verificación de nulidad e inexistencia
		if (deletedClient != null && deletedClient.getClientId() != null) {

			// Eliminación del cliente
			clientDao.delete(deletedClient);
		}

	}

	@Override
	public Client searchById(final Long clientId) {

		// Resultado
		Client client = null;

		// Verificación de nulidad
		if (clientId != null) {

			// Obtención del cliente por ID
			client = clientDao.searchById(clientId);
		}

		return client;
	}

	@Override
	public List<Client> searchAll() {

		// Obtención de todos los clientes
		return clientDao.searchAll();
	}

	@Override
	public List<Client> searchByNameAndIdentityCardNumber(String firstName, Integer identityCardNumber) {

		// Resultado
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad
		if (StringUtils.isNotBlank(firstName)) {

			// Obtención de todos los clientes
			clientsList = clientDao.searchByNameAndIdentityCardNumber(firstName, identityCardNumber);

		}

		return clientsList;

	}

	@Override
	public List<Client> searchByFirstName(final String firstName) {

		// Resultado
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad
		if (StringUtils.isNotBlank(firstName)) {

			// Obtención de todos los clientes
			clientsList = clientDao.searchByFirstName(firstName);
		}

		return clientsList;
	}

	@Override
	public List<Client> searchByFirstNameAndSurnames(String firstName, String firstSurname, String secondSurname) {

		// Resultado
		List<Client> clientsList = new ArrayList<>();

		// Verificación de nulidad
		if (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(firstSurname)
				&& StringUtils.isNotBlank(secondSurname)) {

			// Obtención de todos los clientes
			clientsList = clientDao.searchByFirstNameAndSurnames(firstName, firstSurname, secondSurname);
		}

		return clientsList;
	}

}

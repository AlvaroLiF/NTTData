package com.nttdata.nttdatacenters_hibernate_t1_alf.services;

import java.util.List;

import com.nttdata.nttdatacenters_hibernate_t1_alf.persistence.Client;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Interfaz del servicio de clientes
 * 
 * @author ALF
 *
 */
public interface ClientManagementServiceInterface {

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Actualiza a un cliente existente
	 * 
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Elimina un jugador existente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Obtiene un jugador mediante su ID
	 * 
	 * @param clientId
	 */
	public Client searchById(final Long clientId);

	/**
	 * Búsqueda de todos los registros en BBDD
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Obtiene los clientes por nombre y número del documento de identidad
	 * 
	 * @param firstName
	 * @param identityCardNumber
	 * @return List<Client>
	 */
	public List<Client> searchByFirstNameAndIdentityCardNumber(final String firstName, final Integer identityCardNumber);

	/**
	 * Obtiene jugadores por nombre
	 * 
	 * @param firstName
	 * @return List<Client>
	 */
	public List<Client> searchByFirstName(final String firstName);

	/**
	 * Obtiene jugadores por nombre y primer apellido
	 * 
	 * @param firstName
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Client>
	 */
	public List<Client> searchByFirstNameAndSurnames(final String firstName, final String firstSurname,
			final String secondSurname);

}

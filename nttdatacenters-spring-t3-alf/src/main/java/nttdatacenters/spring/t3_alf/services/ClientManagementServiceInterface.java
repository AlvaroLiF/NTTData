package nttdatacenters.spring.t3_alf.services;

import java.util.List;
import java.util.Optional;

import nttdatacenters.spring.t3_alf.repository.Client;

/**
 * Taller Práctico 3 - Spring
 * 
 * Interfaz de ClientManagementService
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
	public void insertNewClient(Client newClient);

	/**
	 * Actualiza un cliente existente
	 * 
	 * @param updatedClient
	 */
	public void updateClient(Client updatedClient);

	/**
	 * Elimina un cliente existente
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(Client deletedClient);

	/**
	 * Obtiene un cliente mediante su ID
	 * 
	 * @param clientId
	 */
	public Optional<Client> searchById(Long clientId);

	/**
	 * Búsqueda de todos los clientes en BBDD
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

	/**
	 * Obtiene clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return List<Client>
	 */
	public List<Client> searchByFirstNameAndSurnames(String name, String surnames);
}

package nttdatacenters.spring.t3_alf.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nttdatacenters.spring.t3_alf.repository.Client;
import nttdatacenters.spring.t3_alf.repository.ClientRepository;

/**
 * Taller Práctico 3 - Spring
 * 
 * Servicio para la gestión de clientes
 * 
 * @author ALF
 *
 */
@Service
public class ClientManagementServiceImplementation implements ClientManagementServiceInterface {

	@Autowired
	private ClientRepository clientRepo;

	@Override
	public void insertNewClient(Client newClient) {

		clientRepo.save(newClient);

	}

	@Override
	public void updateClient(Client updatedClient) {

		clientRepo.save(updatedClient);

	}

	@Override
	public void deleteClient(Client deletedClient) {

		clientRepo.delete(deletedClient);

	}

	@Override
	public Optional<Client> searchById(Long clientId) {

		return clientRepo.findById(clientId);
	}

	@Override
	public List<Client> searchAll() {

		return clientRepo.findAll();

	}

	@Override
	public List<Client> searchByFirstNameAndSurnames(String name, String surnames) {

		return clientRepo.findByNameAndSurnames(name, surnames);

	}

}

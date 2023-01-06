package nttdatacenters.spring.t3_alf.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nttdatacenters.spring.t3_alf.repository.Client;
import nttdatacenters.spring.t3_alf.services.ClientManagementServiceInterface;

@RestController
public class ClientRestController {

	/** Servicio de clientes **/
	@Autowired
	ClientManagementServiceInterface clientService;

	/**
	 * Muestra todos los clientes
	 * 
	 * @return List<Client>
	 */
	@GetMapping(value = "/allClients")
	public List<Client> getAllClients() {
		return clientService.searchAll();
	}

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param client
	 */
	@PostMapping(value = "/insertClient")
	public void insertNewClient(final @RequestBody Client client) {
		clientService.insertNewClient(client);
	}

	/**
	 * Busca un cliente por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return
	 */
	@GetMapping(path = "/searchCustomer", consumes = "application/json")
	public @ResponseBody List<Client> searchByNameAndSurnames(@RequestParam String name,
			@RequestParam String surnames) {

		return clientService.searchByNameAndSurnames(name, surnames);
	}
}

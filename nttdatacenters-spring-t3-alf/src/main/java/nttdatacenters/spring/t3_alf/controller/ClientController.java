package nttdatacenters.spring.t3_alf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nttdatacenters.spring.t3_alf.repository.Client;
import nttdatacenters.spring.t3_alf.services.ClientManagementServiceInterface;

/**
 * Taller Práctico 3 - Spring
 * 
 * Controlador de cliente
 * 
 * @author ALF
 *
 */
@Controller
public class ClientController {

	/** Servicio de clientes **/
	@Autowired
	ClientManagementServiceInterface clientService;

	/**
	 * Muestra el index
	 * 
	 * @return String
	 */
	@GetMapping("/")
	public String index() {
		return "/index";
	}

	/**
	 * Muestra todos los clientes
	 * 
	 * @param modelo
	 * @return String
	 */
	@GetMapping("/allClients")
	public String getAllClients(Model modelo) {
		List<Client> clients = clientService.searchAll();

		modelo.addAttribute("clients", clients);

		return "/showClients";

	}

	@GetMapping("/insertClient/new")
	public String insertNewClientForm(Model model) {
		Client client = new Client();

		model.addAttribute("client", client);

		return "insertClient";
	}

	/**
	 * Inserta un nuevo cliente
	 * 
	 * @param client
	 * @return String
	 */
	@PostMapping("/insertClient")
	public String insertNewClient(@ModelAttribute("client") Client client) {

		client.setName(client.getName());
		client.setSurnames(client.getSurnames());
		client.setIdentityCardNumber(client.getIdentityCardNumber());
		client.setBirthdate(client.getBirthdate());

		clientService.insertNewClient(client);

		return "redirect:/allClients";

	}

	/**
	 * Muestra los clientes por el nombre
	 * 
	 * @param model
	 * @param name
	 * @return String
	 */
	@GetMapping("/searchClient")
	public String searchClientByName(Model model, @Param("name") String name) {
		List<Client> clients = clientService.searchByName(name);
		model.addAttribute("clients", clients);

		return "searchClient";

	}

}

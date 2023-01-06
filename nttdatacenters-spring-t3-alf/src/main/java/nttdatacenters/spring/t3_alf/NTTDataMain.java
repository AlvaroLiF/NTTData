package nttdatacenters.spring.t3_alf;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nttdatacenters.spring.t3_alf.repository.Client;
import nttdatacenters.spring.t3_alf.services.ClientManagementServiceInterface;

/**
 * Taller Práctico Spring - 2
 * 
 * Clase principal
 * 
 * @author ALF
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);

	/** Servicio de gestión de clientes */
	@Autowired
	private ClientManagementServiceInterface clientService;

	static final String NOMBRE_MARIA = "María";
	static final String APELLIDOS_RODRIGUEZ_PARERA = "Rodríguez Parera";

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de clientes

		log.info("CREACIÓN DE CLIENTES");

		Client client1 = new Client();
		client1.setName("Carlos");
		client1.setSurnames("Madrigal Pérez");
		client1.setBirthdate(LocalDate.of(1996, 8, 12));
		client1.setIdentityCardNumber(524534932);

		Client client2 = new Client();
		client2.setName("Julián");
		client2.setSurnames("Iglesias Martínez");
		client2.setBirthdate(LocalDate.of(1985, 4, 22));
		client2.setIdentityCardNumber(633674525);

		Client client3 = new Client();
		client3.setName(NOMBRE_MARIA);
		client3.setSurnames(APELLIDOS_RODRIGUEZ_PARERA);
		client3.setBirthdate(LocalDate.of(1991, 1, 1));
		client3.setIdentityCardNumber(467884356);

		Client client4 = new Client();
		client4.setName(NOMBRE_MARIA);
		client4.setSurnames(APELLIDOS_RODRIGUEZ_PARERA);
		client4.setBirthdate(LocalDate.of(1997, 11, 30));
		client4.setIdentityCardNumber(467674356);

		// Inserción de los clientes en el servicio

		log.info("INSERCIÓN DE LOS CLIENTES EN EL SERVICIO");

		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		clientService.insertNewClient(client3);
		clientService.insertNewClient(client4);

		// Muestra el cliente buscado por Id

		Optional<Client> client = clientService.searchById((long) 1);

		if (log.isInfoEnabled() && client.isPresent()) {
			log.info(String.format("El cliente con ID: %s es %s %s", client.get().getClientId(), client.get().getName(),
					client.get().getSurnames()));

		}

		// Muestra los clientes buscados por nombre y apellidos

		List<Client> clients = clientService.searchByNameAndSurnames(NOMBRE_MARIA, APELLIDOS_RODRIGUEZ_PARERA);

		for (final Client results : clients) {

			if (log.isInfoEnabled()) {
				log.info(String.format("El cliente con ID: %s es %s %s con DNI: %s y fecha de nacimiento: %s",
						results.getClientId(), results.getName(), results.getSurnames(),
						results.getIdentityCardNumber(), results.getBirthdate()));

			}

		}

	}
}

package nttdatacenters.hibernate.t2_alf.main;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import nttdatacenters.hibernate.t2_alf.persistence.Client;
import nttdatacenters.hibernate.t2_alf.persistence.Contract;
import nttdatacenters.hibernate.t2_alf.persistence.ContractType;
import nttdatacenters.hibernate.t2_alf.services.ClientManagementServiceImplementation;
import nttdatacenters.hibernate.t2_alf.services.ClientManagementServiceInterface;
import nttdatacenters.hibernate.t2_alf.services.ContractManagementServiceImplementation;
import nttdatacenters.hibernate.t2_alf.services.ContractManagementServiceInterface;
import nttdatacenters.hibernate.t2_alf.services.ContractTypeManagementServiceImplementation;
import nttdatacenters.hibernate.t2_alf.services.ContractTypeManagementServiceInterface;

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
	static final String CLIENT_FORMAT = "| ID: %s | NOMBRE: %s | PRIMER APELLIDO: %s | SEGUNDO APELLIDO: %s | DNI: %s |";
	static final String CONTRACT_FORMAT = "| ID: %s | FECHA DE VIGENCIA: %s | FECHA DE CADUCIDAD: %s | PRECIO MENSUAL: %s | ID CLIENTE: %s |";
	static final String CONTRACT_TYPE_FORMAT = "| ID: %s | TIPO DE CONTRATO: %s | PORCENTAJE DE IMPUESTOS: %s";

	// Apertura de sesión
	static final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

	// Inicialización de servicios
	static final ClientManagementServiceInterface clientService = new ClientManagementServiceImplementation(session);
	static final ContractManagementServiceInterface contractService = new ContractManagementServiceImplementation(
			session);
	static final ContractTypeManagementServiceInterface contractTypeService = new ContractTypeManagementServiceImplementation(
			session);

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Auditoría
		final String updatedUser = "ALF_SYS";
		final Date updatedDate = new Date();

		// Generación de clientes
		log.info("Creación de los clientes");

		final Client client1 = new Client();
		client1.setFirstName("Juan");
		client1.setFirstSurname("Álvarez");
		client1.setSecondSurname("Domínguez");
		client1.setIdentityCardNumber(242452525);
		client1.setUpdatedUser(updatedUser);
		client1.setUpdatedDate(updatedDate);

		final Client client2 = new Client();
		client2.setFirstName("Julian");
		client2.setFirstSurname("Muñoz");
		client2.setSecondSurname("Fernández");
		client2.setIdentityCardNumber(124534453);
		client2.setUpdatedUser(updatedUser);
		client2.setUpdatedDate(updatedDate);

		final Client client3 = new Client();
		client3.setFirstName("María");
		client3.setFirstSurname("Becerra");
		client3.setSecondSurname("Moreno");
		client3.setIdentityCardNumber(542976932);
		client3.setUpdatedUser(updatedUser);
		client3.setUpdatedDate(updatedDate);

		final Client client4 = new Client();
		client4.setFirstName("Jesús");
		client4.setFirstSurname("Pedrerol");
		client4.setSecondSurname("Ugarte");
		client4.setIdentityCardNumber(412231435);
		client4.setUpdatedUser(updatedUser);
		client4.setUpdatedDate(updatedDate);

		// Generación de contratos
		log.info("Creación de los contratos");

		final Contract contract1 = new Contract();
		contract1.setClient(client3);
		contract1.setEffectiveDate(LocalDate.now());
		contract1.setExpirationDate(LocalDate.of(2024, 10, 24));
		contract1.setMonthlyPrice(9.99);
		contract1.setUpdatedUser(updatedUser);
		contract1.setUpdatedDate(updatedDate);

		final Contract contract2 = new Contract();
		contract2.setClient(client4);
		contract2.setEffectiveDate(LocalDate.now());
		contract2.setExpirationDate(LocalDate.of(2023, 05, 13));
		contract2.setMonthlyPrice(12.99);
		contract2.setUpdatedUser(updatedUser);
		contract2.setUpdatedDate(updatedDate);

		// Generación de los tipos de contrato
		log.info("Creación de los tipos de contrato");

		final ContractType contractType1 = new ContractType();
		contractType1.setContract(contract1);
		contractType1.setType("Suscripción a Netflix");
		contractType1.setTaxRate(21);
		contractType1.setUpdatedUser(updatedUser);
		contractType1.setUpdatedDate(updatedDate);

		final ContractType contractType2 = new ContractType();
		contractType2.setContract(contract1);
		contractType2.setType("Suscripción a pañales mensuales");
		contractType2.setTaxRate(10);
		contractType2.setUpdatedUser(updatedUser);
		contractType2.setUpdatedDate(updatedDate);

		// Inserción de los clientes
		log.info("Inserción de los clientes");

		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		clientService.insertNewClient(client3);
		clientService.insertNewClient(client4);

		// Inserción de los contratos
		log.info("Inserción de los contratos");

		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);

		// Inserción de los tipos de contrato
		log.info("Inserción de los tipos de contrato");

		contractTypeService.insertNewContractType(contractType1);
		contractTypeService.insertNewContractType(contractType2);

		// Borrado del client1
		clientService.deleteClient(client1);

		// Actualización del nombre del client2
		client2.setFirstName("Marcos");
		clientService.updateClient(client2);

		// Actualización del contrato2
		contract2.setMonthlyPrice(14.99);
		contractService.updateContract(contract2);

		// Se muestran todos los clientes
		searchAll();

		// Se muestran los clientes por nombre
		searchByFirstName("Marcos");

		// Se muestran los clientes por nombre y apellidos
		searchByFirstNameAndSurnames("María", "Becerra", "Moreno");

		// Se muestran los clientes por nombre y número de documento de identidad
		searchByFirstNameAndIdentityCardNumber("Jesús", 412231435);

		// Se muestran los contratos por precio mensual y fecha de caducidad
		searchByMonthlyPriceAndExpirationDate(9.99, LocalDate.of(2024, 10, 24));

		// Se muestran los tipos de contrato por porcentaje de impuestos
		searchByTaxRate(21);

		// Se muestran los contratos por el id del cliente
		searchByClientId((long) 3);

		// Cierre de sesión
		session.close();

	}

	/**
	 * Método que obtiene todos los clientes
	 */
	public static void searchAll() {

		try {

			List<Client> clients = clientService.searchAll();

			for (final Client client : clients) {

				if (log.isInfoEnabled()) {
					log.info(String.format(CLIENT_FORMAT, client.getClientId(), client.getFirstName(),
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
					log.info(String.format(CLIENT_FORMAT, client.getClientId(), client.getFirstName(),
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
					log.info(String.format(CLIENT_FORMAT, client.getClientId(), client.getFirstName(),
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
					log.info(String.format(CLIENT_FORMAT, client.getClientId(), client.getFirstName(),
							client.getFirstSurname(), client.getSecondSurname(), client.getIdentityCardNumber()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	/**
	 * Método que obtiene los contratos por precio mensual y fecha de caducidad
	 * 
	 * @param monthlyPrice
	 * @param expirationDate
	 */
	public static void searchByMonthlyPriceAndExpirationDate(Double monthlyPrice, LocalDate expirationDate) {

		try {

			List<Contract> contracts = contractService.searchByMonthlyPriceAndExpirationDate(monthlyPrice,
					expirationDate);
			for (final Contract contract : contracts) {

				if (log.isInfoEnabled()) {
					log.info(String.format(CONTRACT_FORMAT, contract.getContractId(), contract.getEffectiveDate(),
							contract.getExpirationDate(), contract.getMonthlyPrice()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	/**
	 * Método que obtiene los tipos de contrato por porcentaje de impuestos
	 * 
	 * @param taxRate
	 */
	public static void searchByTaxRate(Integer taxRate) {

		try {

			List<ContractType> contractTypes = contractTypeService.searchByTaxRate(taxRate);
			for (final ContractType contractType : contractTypes) {

				if (log.isInfoEnabled()) {
					log.info(String.format(CONTRACT_TYPE_FORMAT, contractType.getContractTypeId(),
							contractType.getType(), contractType.getTaxRate()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}

	public static void searchByClientId(Long clientId) {

		try {

			List<Contract> contracts = contractService.searchByClientId(clientId);
			for (final Contract contract : contracts) {

				if (log.isInfoEnabled()) {
					log.info(String.format(CONTRACT_FORMAT, contract.getContractId(), contract.getEffectiveDate(),
							contract.getExpirationDate(), contract.getMonthlyPrice(),
							contract.getClient().getClientId()));
				}
			}

		} catch (Exception ex) {

			log.error(ex.getMessage());
		}

	}
}

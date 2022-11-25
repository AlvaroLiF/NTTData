package nttdatacenters.hibernate.t2_alf.services;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import nttdatacenters.hibernate.t2_alf.persistence.Contract;
import nttdatacenters.hibernate.t2_alf.persistence.ContractDaoImplementation;
import nttdatacenters.hibernate.t2_alf.persistence.ContractDaoInterface;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * Implementación del servicio de contratos
 * 
 * @author ALF
 *
 */
public class ContractManagementServiceImplementation implements ContractManagementServiceInterface {

	/** DAO: NTTDATA_CONTRACT */
	private ContractDaoInterface contractDao;

	/** Método constructor */
	public ContractManagementServiceImplementation(final Session session) {
		this.contractDao = new ContractDaoImplementation(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {

		// Verificación de nulidad e inexistencia
		if (newContract != null && newContract.getContractId() == null) {

			// Inserción del nuevo contrato
			contractDao.insert(newContract);
		}
	}

	@Override
	public void updateContract(Contract updatedContract) {

		// Verificación de nulidad e inexistencia
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del contrato
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deletedContract(Contract deletedContract) {

		// Verificación de nulidad e inexistencia
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Eliminación del contrato
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(Long contractId) {

		// Resultado
		Contract contract = null;

		// Verificación de nulidad
		if (contractId != null) {

			// Obtención del contrato por ID
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {

		// Obtención de todos los contratos
		return contractDao.searchAll();
	}

	@Override
	public List<Contract> searchByEffectiveDate(LocalDate effectiveDate) {

		// Resultado
		List<Contract> contractsList = new ArrayList<>();

		// Verificación de nulidad
		if (effectiveDate != null) {

			// Obtención de los contratos por fecha de vigencia
			contractsList = contractDao.searchByEffectiveDate(effectiveDate);

		}

		return contractsList;
	}

	@Override
	public List<Contract> searchByExpirationDate(LocalDate expirationDate) {

		// Resultado
		List<Contract> contractsList = new ArrayList<>();

		// Verificación de nulidad
		if (expirationDate != null) {

			// Obtención de los contratos por fecha de caducidad
			contractsList = contractDao.searchByExpirationDate(expirationDate);

		}

		return contractsList;
	}

	@Override
	public List<Contract> searchByMonthlyPriceAndExpirationDate(Double monthlyPrice, LocalDate expirationDate) {

		// Resultado
		List<Contract> contractsList = new ArrayList<>();

		// Verificación del precio mensual y de nulidad
		if (monthlyPrice > 0 && expirationDate != null) {

			// Obtención de los contratos por precio mensual y fecha de caducidad
			contractsList = contractDao.searchByMonthlyPriceAndExpirationDate(monthlyPrice, expirationDate);

		}

		return contractsList;
	}

	@Override
	public List<Contract> searchByClientId(Long clientId) {

		// Resultado
		List<Contract> contractsList = new ArrayList<>();

		// Verificación del precio mensual y de nulidad
		if (clientId != null) {

			// Obtención de los contratos por precio mensual y fecha de caducidad
			contractsList = contractDao.searchByClientId(clientId);

		}

		return contractsList;

	}

}

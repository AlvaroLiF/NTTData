package nttdatacenters.hibernate.t2_alf.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import nttdatacenters.hibernate.t2_alf.persistence.ContractType;
import nttdatacenters.hibernate.t2_alf.persistence.ContractTypeDaoImplementation;
import nttdatacenters.hibernate.t2_alf.persistence.ContractTypeDaoInterface;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * Implementación del servicio de tipos de contrato
 * 
 * @author ALF
 *
 */
public class ContractTypeManagementServiceImplementation implements ContractTypeManagementServiceInterface {

	/** DAO: NTTDATA_CONTRACT_TYPE */
	private ContractTypeDaoInterface contractTypeDao;

	/** Método constructor */
	public ContractTypeManagementServiceImplementation(final Session session) {
		this.contractTypeDao = new ContractTypeDaoImplementation(session);
	}

	@Override
	public void insertNewContractType(ContractType newContractType) {

		// Verificación de nulidad e inexistencia
		if (newContractType != null && newContractType.getContractTypeId() == null) {

			// Inserción del nuevo tipo de contrato
			contractTypeDao.insert(newContractType);
		}

	}

	@Override
	public void updateContractType(ContractType updatedContractType) {
		// Verificación de nulidad e inexistencia
		if (updatedContractType != null && updatedContractType.getContractTypeId() != null) {

			// Actualización del tipo de contrato
			contractTypeDao.update(updatedContractType);
		}

	}

	@Override
	public void deletedContractType(ContractType deletedContractType) {

		// Verificación de nulidad e inexistencia
		if (deletedContractType != null && deletedContractType.getContractTypeId() != null) {

			// Eliminación del tipo de contrato
			contractTypeDao.delete(deletedContractType);
		}

	}

	@Override
	public ContractType searchById(Long contracTypetId) {
		// Resultado
		ContractType contractType = null;

		// Verificación de nulidad
		if (contracTypetId != null) {

			// Obtención del contrato por ID
			contractType = contractTypeDao.searchById(contracTypetId);
		}

		return contractType;
	}

	@Override
	public List<ContractType> searchAll() {

		// Obtención de todos los tipos de contrato
		return contractTypeDao.searchAll();
	}

	@Override
	public List<ContractType> searchByType(String type) {

		// Resultado
		List<ContractType> contractsTypeList = new ArrayList<>();

		// Verificación de nulidad
		if (StringUtils.isNotBlank(type)) {

			// Obtención de todos los tipos de contrato
			contractsTypeList = contractTypeDao.searchByType(type);

		}

		return contractsTypeList;
	}

	@Override
	public List<ContractType> searchByTaxRate(Integer taxRate) {

		// Resultado
		List<ContractType> contractsTypeList = new ArrayList<>();

		// Verificación de nulidad
		if (taxRate > 0) {

			// Obtención de todos los tipos de contrato
			contractsTypeList = contractTypeDao.searchByTaxRate(taxRate);

		}

		return contractsTypeList;
	}

	@Override
	public List<ContractType> searchByTypeAndTaxRate(String type, Integer taxRate) {

		// Resultado
		List<ContractType> contractsTypeList = new ArrayList<>();

		// Verificación de nulidad
		if (StringUtils.isNotBlank(type) && taxRate > 0) {

			// Obtención de todos los tipos de contrato
			contractsTypeList = contractTypeDao.searchByTypeAndTaxRate(type, taxRate);

		}

		return contractsTypeList;

	}
}

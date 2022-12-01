package nttdatacenters.hibernate.t3_alf.services;

import java.util.List;

import nttdatacenters.hibernate.t3_alf.persistence.ContractType;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * Interfaz del servicio de tipos de contrato
 * 
 * @author ALF
 *
 */
public interface ContractTypeManagementServiceInterface {

	/**
	 * Inserta un nuevo tipo de contrato
	 * 
	 * @param newContractType
	 */
	public void insertNewContractType(final ContractType newContractType);

	/**
	 * Actualiza un tipo contrato existente
	 * 
	 * @param updatedContractType
	 */
	public void updateContractType(final ContractType updatedContractType);

	/**
	 * Elimina un tipo de contrato existente
	 * 
	 * @param deletedContractType
	 */
	public void deletedContractType(final ContractType deletedContractType);

	/**
	 * Obtiene un tipo contrato mediante su ID
	 * 
	 * @param contractTypeId
	 */
	public ContractType searchById(final Long contracTypetId);

	/**
	 * Búsqueda de todos los registros en BBDD
	 * 
	 * @return List<ContractType>
	 */
	public List<ContractType> searchAll();

	/**
	 * Obtiene los tipos de contrato según el tipo
	 * 
	 * @param type
	 * @return
	 */
	public List<ContractType> searchByType(final String type);

	/**
	 * Obtiene los tipos de contrato según el porcentaje de impuestos
	 * 
	 * @param taxRate
	 * @return
	 */
	public List<ContractType> searchByTaxRate(final Integer taxRate);

	/**
	 * Obtiene los tipos de contrato según el tipo y el porcentaje de impuestos
	 * 
	 * @param type
	 * @param taxRate
	 * @return
	 */
	public List<ContractType> searchByTypeAndTaxRate(final String type, final Integer taxRate);
}

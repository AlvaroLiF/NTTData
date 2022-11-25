package nttdatacenters.hibernate.t2_alf.services;

import java.time.LocalDate;
import java.util.List;

import nttdatacenters.hibernate.t2_alf.persistence.Contract;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * Interfaz del servicio de contratos
 * 
 * @author ALF
 *
 */
public interface ContractManagementServiceInterface {

	/**
	 * Inserta un nuevo contrato
	 * 
	 * @param newContract
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente
	 * 
	 * @param updatedClient
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente
	 * 
	 * @param deletedClient
	 */
	public void deletedContract(final Contract deletedContract);

	/**
	 * Obtiene un contrato mediante su ID
	 * 
	 * @param contractId
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Búsqueda de todos los registros en BBDD
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

	/**
	 * Obtiene los contratos por la fecha de vigencia
	 * 
	 * @param effectiveDate
	 * @return List<Contract>
	 */
	public List<Contract> searchByEffectiveDate(LocalDate effectiveDate);

	/**
	 * Obtiene los contratos por la fecha de caducidad
	 * 
	 * @param expirationDate
	 * @return List<Contract>
	 */
	public List<Contract> searchByExpirationDate(LocalDate expirationDate);

	/**
	 * Obtiene los contratos por el precio mensual y la fecha de caducidad
	 * 
	 * @param monthlyPrice
	 * @param expirationDate
	 * @return List<Contract>
	 */
	public List<Contract> searchByMonthlyPriceAndExpirationDate(Double monthlyPrice, LocalDate expirationDate);

	/**
	 * Obtiene contratos por el id del cliente
	 * 
	 * @param clientId
	 * @return
	 */
	public List<Contract> searchByClientId(final Long clientId);
}

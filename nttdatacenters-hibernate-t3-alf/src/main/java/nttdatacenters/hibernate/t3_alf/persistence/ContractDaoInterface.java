package nttdatacenters.hibernate.t3_alf.persistence;

import java.time.LocalDate;
import java.util.List;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * DAO de tabla NTTDATA_CONTRACT
 * 
 * @author ALF
 *
 */
public interface ContractDaoInterface extends CommonDaoInterface<Contract> {

	/**
	 * Obtiene contratos por la fecha de vigencia
	 * 
	 * @param effectiveDate
	 * @return
	 */
	public List<Contract> searchByEffectiveDate(final LocalDate effectiveDate);

	/**
	 * Obtiene contratos por la fecha de caducidad
	 * 
	 * @param expirationDate
	 * @return
	 */
	public List<Contract> searchByExpirationDate(final LocalDate expirationDate);

	/**
	 * Obtiene contratos por el precio mensual y la fecha de caducidad
	 * 
	 * @param monthlyPrice
	 * @param expirationDate
	 * @return
	 */
	public List<Contract> searchByMonthlyPriceAndExpirationDate(final Double monthlyPrice,
			final LocalDate expirationDate);

	/**
	 * Obtiene contratos por el id del cliente
	 * 
	 * @param clientId
	 * @return
	 */
	public List<Contract> searchByClientId(final Long clientId);

	/**
	 * Obtiene contratos por precio mensual y porcentaje de impuestos
	 * 
	 * @param monthlyPrice
	 * @param taxRate
	 * @return
	 */
	public List<Contract> searchByMonthlyPriceAndContractTypeTaxRate(final Double monthlyPrice, final Integer taxRate);

	/**
	 * Obtiene contratos por la fecha de caducidad del contrato y el nombre del
	 * cliente
	 * 
	 * @param expirationDate
	 * @param firstName
	 * @return
	 */
	public List<Contract> searchByExpirationDateAndFirstName(final LocalDate expirationDate, final String firstName);
}

package nttdatacenters.hibernate.t2_alf.persistence;

import java.time.LocalDate;
import java.util.List;

/**
 * Taller Práctico 2 - Hibernate
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
}

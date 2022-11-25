package nttdatacenters.hibernate.t2_alf.persistence;

import java.util.List;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * DAO de tabla NTTDATA_CONTRACT_TYPE
 * 
 * @author ALF
 *
 */
public interface ContractTypeDaoInterface extends CommonDaoInterface<ContractType> {

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

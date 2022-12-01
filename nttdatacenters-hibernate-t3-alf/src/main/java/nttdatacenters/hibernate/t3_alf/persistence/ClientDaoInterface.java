package nttdatacenters.hibernate.t3_alf.persistence;

import java.util.List;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * DAO de tabla NTTDATA_CLIENT
 * 
 * @author ALF
 *
 */
public interface ClientDaoInterface extends CommonDaoInterface<Client> {

	/**
	 * Obtiene clientes por nombre y número de documento de identidad
	 * 
	 * @param firstName
	 * @param identityCardNumber
	 * @return List<Client>
	 */
	public List<Client> searchByNameAndIdentityCardNumber(final String firstName, final Integer identityCardNumber);

	/**
	 * Obtiene clientes por nombre
	 * 
	 * @param firstName
	 * @return List<Client>
	 */
	public List<Client> searchByFirstName(final String firstName);

	/**
	 * Obtiene clientes por nombre y apellidos
	 * 
	 * @param firstName
	 * @param firstSurname
	 * @param secondSurname
	 * @return List<Client>
	 */
	public List<Client> searchByFirstNameAndSurnames(final String firstName, final String firstSurname,
			final String secondSurname);

	/**
	 * Obtiene los clientes por el número de documento de identidad y precio mensual
	 * 
	 * @param identityCardNumber
	 * @param monthlyPrice
	 * @return
	 */
	public List<Client> searchByIdentityCardNumberAndMonthlyPrice(final Integer identityCardNumber,
			final Double monthlyPrice);
}

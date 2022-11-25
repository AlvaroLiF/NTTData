package nttdatacenters.hibernate.t2_alf.persistence;

import java.util.List;

/**
 * Taller Práctico 2 - Hibernate
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

}

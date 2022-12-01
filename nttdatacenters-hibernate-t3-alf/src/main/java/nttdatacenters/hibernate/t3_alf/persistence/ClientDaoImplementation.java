package nttdatacenters.hibernate.t3_alf.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * Implementación del DAO de tabla NTTDATA_CLIENT
 * 
 * @author ALF
 *
 */
public class ClientDaoImplementation extends CommonDaoImplementation<Client> implements ClientDaoInterface {

	/** Sesión de conexión a BD */
	private Session session;

	/** Método constructor */
	public ClientDaoImplementation(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Constante con el inicio de la consulta en la tabla client buscando por el
	 * firstName
	 */
	static final String NAMEQUERY = "FROM Client WHERE firstName='";

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByNameAndIdentityCardNumber(String firstName, Integer identityCardNumber) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "' AND identityCardNumber=" + identityCardNumber).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstName(String firstName) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstNameAndSurnames(String firstName, String firstSurname, String secondSurname) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los clientes en función del nombre y del número del documento de
		// identidad
		return session.createQuery(NAMEQUERY + firstName + "' AND firstSurname='" + firstSurname
				+ "' AND secondSurname='" + secondSurname + "'").list();
	}

	@Override
	public List<Client> searchByIdentityCardNumberAndMonthlyPrice(Integer identityCardNumber, Double monthlyPrice) {

		// Consulta
		final CriteriaBuilder cbuilder = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cbuilder.createQuery(Client.class);
		final Root<Client> rootClient = cquery.from(Client.class);
		final Join<Client, Contract> clientJoinContract = rootClient.join("contractList");

		// Where
		final Predicate pr1 = cbuilder.equal(clientJoinContract.getParent().<Integer>get("identityCardNumber"),
				identityCardNumber);
		final Predicate pr2 = cbuilder.gt(clientJoinContract.<Double>get("monthlyPrice"), monthlyPrice);

		// Consulta
		cquery.select(rootClient).where(cbuilder.and(pr1, pr2));

		// Ejecución de la consulta
		return session.createQuery(cquery).getResultList();
	}

}

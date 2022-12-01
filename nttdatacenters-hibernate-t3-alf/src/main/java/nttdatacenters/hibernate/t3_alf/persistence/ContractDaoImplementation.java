package nttdatacenters.hibernate.t3_alf.persistence;

import java.time.LocalDate;
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
 * Implementación del DAO de tabla NTTDATA_CONTRACT
 * 
 * @author ALF
 *
 */
public class ContractDaoImplementation extends CommonDaoImplementation<Contract> implements ContractDaoInterface {

	/** Sesión de conexión a BD */
	private Session session;

	/** Método constructor */
	public ContractDaoImplementation(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Constante con el inicio de la consulta en la tabla contract
	 */
	static final String NAMEQUERY = "FROM Contract WHERE ";

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByEffectiveDate(LocalDate effectiveDate) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los contratos en función de la fecha vigente
		return session.createQuery(NAMEQUERY + "effectiveDate = '" + effectiveDate + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByExpirationDate(LocalDate expirationDate) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los contratos por la fecha de caducidad
		return session.createQuery(NAMEQUERY + "expirationDate = '" + expirationDate + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByMonthlyPriceAndExpirationDate(Double monthlyPrice, LocalDate expirationDate) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los contratos por el precio mensual y la fecha de caducidad
		return session
				.createQuery(
						NAMEQUERY + "monthlyPrice = " + monthlyPrice + " AND expirationDate = '" + expirationDate + "'")
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByClientId(Long clientId) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Obtenemos los contratos por el precio mensual y la fecha de caducidad
		return session.createQuery(NAMEQUERY + "client = " + clientId).list();
	}

	@Override
	public List<Contract> searchByMonthlyPriceAndContractTypeTaxRate(Double monthlyPrice, Integer taxRate) {

		// Consulta
		final CriteriaBuilder cbuilder = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cbuilder.createQuery(Contract.class);
		final Root<Contract> rootContract = cquery.from(Contract.class);
		final Join<Contract, ContractType> contractJoinContractType = rootContract.join("contractType");

		// Where
		final Predicate pr1 = cbuilder.lt(contractJoinContractType.getParent().<Double>get("monthlyPrice"),
				monthlyPrice);
		final Predicate pr2 = cbuilder.greaterThanOrEqualTo(contractJoinContractType.<Integer>get("taxRate"), taxRate);

		// Consulta
		cquery.select(rootContract).where(cbuilder.and(pr1, pr2));

		// Ejecución de la consulta
		return session.createQuery(cquery).getResultList();
	}

	@Override
	public List<Contract> searchByExpirationDateAndFirstName(LocalDate expirationDate, String firstName) {

		// Consulta
		final CriteriaBuilder cbuilder = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cbuilder.createQuery(Contract.class);
		final Root<Contract> rootContract = cquery.from(Contract.class);
		final Join<Contract, Client> contractJoinClient = rootContract.join("client");

		// Where
		final Predicate pr1 = cbuilder.equal(contractJoinClient.getParent().<LocalDate>get("expirationDate"),
				expirationDate);
		final Predicate pr2 = cbuilder.like(contractJoinClient.<String>get("firstName"), firstName);

		// Consulta
		cquery.select(rootContract).where(cbuilder.and(pr1, pr2));

		// Ejecución de la consulta
		return session.createQuery(cquery).getResultList();
	}

}

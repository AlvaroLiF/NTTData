package nttdatacenters.hibernate.t2_alf.persistence;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

/**
 * Taller Práctico 2 - Hibernate
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

}

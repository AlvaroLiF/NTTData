package nttdatacenters.hibernate.t3_alf.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * Implementación del DAO de tabla NTTDATA_CONTRACT_TYPE
 * 
 * @author ALF
 *
 */
public class ContractTypeDaoImplementation extends CommonDaoImplementation<ContractType>
		implements ContractTypeDaoInterface {

	/** Sesión de conexión a BD */
	private Session session;

	/** Método constructor */
	public ContractTypeDaoImplementation(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Constante con el inicio de la consulta en la tabla contractType
	 */
	static final String NAMEQUERY = "FROM ContractType WHERE ";

	@SuppressWarnings("unchecked")
	@Override
	public List<ContractType> searchByType(String type) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Obtenemos los tipos de contratos por el tipo
		return session.createQuery(NAMEQUERY + "type = '" + type + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContractType> searchByTaxRate(Integer taxRate) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Obtenemos los tipos de contratos por el tipo
		return session.createQuery(NAMEQUERY + "taxRate = " + taxRate).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContractType> searchByTypeAndTaxRate(String type, Integer taxRate) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		// Obtenemos los tipos de contratos por el tipo
		return session.createQuery(NAMEQUERY + "type = '" + type + "' AND taxRate = " + taxRate).list();
	}

}

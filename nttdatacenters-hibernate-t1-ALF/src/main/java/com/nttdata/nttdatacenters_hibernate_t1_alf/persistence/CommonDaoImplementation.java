package com.nttdata.nttdatacenters_hibernate_t1_alf.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Implementación del DAO genérico
 * 
 * @author ALF
 *
 */
public class CommonDaoImplementation<T> implements CommonDaoInterface<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor
	 * 
	 * @param session
	 * 
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImplementation(Session session) {
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserción
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Actualización
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Borrado
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por id
		return session.get(this.entityClass, id);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de la apertura de sesión
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		return session.createQuery("FROM " + this.entityClass.getName()).list();
	}

	/**
	 * Devuelve la entityClass
	 * 
	 * @return entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * Establece la entityClass
	 * 
	 * @param entityClass
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}

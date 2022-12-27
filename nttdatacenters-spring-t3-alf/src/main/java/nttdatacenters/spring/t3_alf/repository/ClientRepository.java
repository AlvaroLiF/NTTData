package nttdatacenters.spring.t3_alf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Taller Práctico 3 - Spring
 * 
 * Repositorio de clientes
 * 
 * @author ALF
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	/**
	 * Busca los clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return
	 */
	List<Client> findByNameAndSurnames(String name, String surnames);

}

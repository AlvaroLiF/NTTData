package nttdatacenters.spring.t2_alf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Taller Práctico 2 - Spring
 * 
 * Repositorio de productos
 * 
 * @author ALF
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

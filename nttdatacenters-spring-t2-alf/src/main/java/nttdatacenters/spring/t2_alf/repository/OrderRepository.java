package nttdatacenters.spring.t2_alf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Taller Práctico 2 - Spring
 * 
 * Repositorio de pedidos
 * 
 * @author ALF
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}

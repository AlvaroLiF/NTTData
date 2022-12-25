package nttdatacenters.spring.t2_alf.services;

import nttdatacenters.spring.t2_alf.repository.Order;
import nttdatacenters.spring.t2_alf.repository.Product;

/**
 * Taller Práctico 2 - Spring
 * 
 * Interfaz de ShippingManagementService
 * 
 * @author ALF
 *
 */
public interface ShippingManagementServiceInterface {

	/**
	 * Creación de un nuevo pedido
	 * 
	 * @param newOrder
	 */
	public void createOrder(Order newOrder);

	/**
	 * Inserción de un producto a un pedido
	 * 
	 * @param product
	 * @param order
	 */
	public void addProductToAnOrder(Product product, Order order);

	/**
	 * Desglosa los productos de un pedido
	 * 
	 * @param order
	 */
	public void breakDownOrder(Order order);

}

package nttdatacenters.spring.t2_alf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nttdatacenters.spring.t2_alf.repository.Order;
import nttdatacenters.spring.t2_alf.repository.Product;
import nttdatacenters.spring.t2_alf.services.ShippingManagementServiceInterface;

/**
 * Taller Práctico Spring - 2
 * 
 * Clase principal
 * 
 * @author ALF
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {
	
	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(NTTDataMain.class);


	/** Servicio: dentro de la península */
	@Autowired
	@Qualifier("insidePeninsula")
	private ShippingManagementServiceInterface shippingServicePeninsula;

	/** Servicio: fuera de la península */
	@Autowired
	@Qualifier("outsidePeninsula")
	private ShippingManagementServiceInterface shippingServiceCMC;

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Creación de pedidos
		
		log.info("CREACIÓN DE PEDIDOS");
		
		Order order1 = new Order();
		order1.setAddressee("Juan Carlos");
		order1.setDeliveryAddress("Calle Barcelona, numero 26");
		order1.setIsInPeninsula(false);

		Order order2 = new Order();
		order2.setAddressee("Jaime");
		order2.setDeliveryAddress("Calle Alemania, numero 13");
		order2.setIsInPeninsula(false);

		Order order3 = new Order();
		order3.setAddressee("Valentina");
		order3.setDeliveryAddress("Calle Trafalgar, numero 5");
		order3.setIsInPeninsula(true);
		
		// Creación de productos
		
		log.info("CREACIÓN DE PRODUCTOS");
		
		Product product1 = new Product();
		product1.setName("Jamón");
		product1.setRetailPrice(115.00);

		Product product2 = new Product();
		product2.setName("Queso");
		product2.setRetailPrice(45.00);

		Product product3 = new Product();
		product3.setName("Gambas");
		product3.setRetailPrice(65.00);

		Product product4 = new Product();
		product4.setName("Desodorante");
		product4.setRetailPrice(1.50);

		Product product5 = new Product();
		product5.setName("Caja de bombones");
		product5.setRetailPrice(17.00);

		// Inserción de los pedidos en el servicio
		
		log.info("INSERCIÓN DE LOS PEDIDOS EN EL SERVICIO");
		
		shippingServiceCMC.createOrder(order1);
		shippingServiceCMC.createOrder(order2);
		shippingServicePeninsula.createOrder(order3);

		// Adición de los productos a los pedidos
		
		log.info("ADICIÓN DE LOS PRODUCTOS A LOS PEDIDOS");
		
		shippingServiceCMC.addProductToAnOrder(product1, order1);
		shippingServiceCMC.addProductToAnOrder(product2, order1);
		shippingServiceCMC.addProductToAnOrder(product3, order2);
		shippingServicePeninsula.addProductToAnOrder(product4, order3);
		shippingServicePeninsula.addProductToAnOrder(product5, order3);

		// Desglose de los pedidos
		
		log.info("DESGLOSE DE LOS PEDIDOS");
		
		shippingServiceCMC.breakDownOrder(order1);
		shippingServiceCMC.breakDownOrder(order2);
		shippingServicePeninsula.breakDownOrder(order3);

		// Comprobamos que no se puede hacer uso del servicio de pedidos fuera de la
		// Península para pedidos de dentro de la Península
		
		log.info("COMPROBACIÓN DEL USO INCORRECTO DEL SERVICIO DE PEDIDOS FUERA DE LA PENÍNSULA");
		
		shippingServiceCMC.createOrder(order3);
		shippingServiceCMC.addProductToAnOrder(product5, order3);
		shippingServiceCMC.breakDownOrder(order3);

		// Comprobamos que no se puede hacer uso del servicio de pedidos dentro de la
		// Península para pedidos de fuera de la Península
		
		log.info("COMPROBACIÓN DEL USO INCORRECTO DEL SERVICIO DE PEDIDOS DENTRO DE LA PENÍNSULA");

		shippingServicePeninsula.createOrder(order1);
		shippingServicePeninsula.addProductToAnOrder(product5, order1);
		shippingServicePeninsula.breakDownOrder(order1);
	}
}

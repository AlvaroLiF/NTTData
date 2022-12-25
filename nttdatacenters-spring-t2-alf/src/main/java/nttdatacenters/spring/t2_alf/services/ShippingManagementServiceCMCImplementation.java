package nttdatacenters.spring.t2_alf.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nttdatacenters.spring.t2_alf.repository.Order;
import nttdatacenters.spring.t2_alf.repository.OrderRepository;
import nttdatacenters.spring.t2_alf.repository.Product;
import nttdatacenters.spring.t2_alf.repository.ProductRepository;

/**
 * Taller Práctico 2 - Spring
 * 
 * Servicio para los pedidos fuera de la Península
 * 
 * @author ALF
 *
 */
@Service("outsidePeninsula")
public class ShippingManagementServiceCMCImplementation implements ShippingManagementServiceInterface {

	/** LOGGER **/
	private static Logger log = LoggerFactory.getLogger(ShippingManagementServiceCMCImplementation.class);

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private ProductRepository productRepo;

	@Override
	public void createOrder(Order newOrder) {

		if (Boolean.FALSE.equals(newOrder.getIsInPeninsula())) {

			orderRepo.save(newOrder);

		} else {

			log.error("El pedido que se ha intentado insertar está dentro de la Península");
		}
	}

	@Override
	public void addProductToAnOrder(Product product, Order order) {

		if (Boolean.FALSE.equals(order.getIsInPeninsula())) {

			double tax = (product.getRetailPrice() * 4) / 100;

			product.setPriceWithTax(product.getRetailPrice() + tax);

			product.setOrder(order);

			productRepo.save(product);

		} else {

			log.error("El pedido al que se ha intentado insertar un producto está dentro de la Península");

		}

	}

	@Override
	public void breakDownOrder(Order order) {

		if (Boolean.FALSE.equals(order.getIsInPeninsula())) {

			Optional<Order> ord = orderRepo.findById(order.getOrderId());

			if (log.isInfoEnabled()) {

				log.info(String.format(
						"Pedido fuera de la Península con ID: %s a nombre de: %s y con dirección de entrega: %s",
						order.getOrderId(), order.getAddressee(), order.getDeliveryAddress()));
			}

			if (ord.isPresent()) {

				for (int i = 0; i < ord.get().getProduct().size(); i++) {

					if (log.isInfoEnabled()) {

						log.info(String.format("Producto: %s con PVP: %s € y precio con IPSI aplicado: %s €",
								ord.get().getProduct().get(i).getName(), ord.get().getProduct().get(i).getRetailPrice(),
								ord.get().getProduct().get(i).getPriceWithTax()));
					}
				}

			}

		} else {

			log.error("El pedido que se ha intentado desglosar está dentro de la Península");

		}

	}
}

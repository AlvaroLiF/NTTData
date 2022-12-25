package nttdatacenters.spring.t2_alf.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;

/**
 * Taller Práctico 2 - Spring
 * 
 * Entidad de la tabla Order
 * 
 * @author ALF
 * 
 */

@Entity
@Table(name = "NTTDATA_ORDER")
public class Order implements Serializable {

	/** Serial version **/
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long orderId;

	/** Destinatario */
	private String addressee;

	/** Dirección de entrega */
	private String deliveryAddress;

	/** Indica si la dirección de entrega es fuera o dentro de la península */
	private Boolean isInPeninsula;

	/** Lista de productos relacionados */
	private List<Product> products;

	/**
	 * Devuelve el Id del pedido
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * Establece el Id del pedido
	 * 
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * Devuelve el destinatario
	 * 
	 * @return
	 */
	@Column(name = "ADDRESSEE")
	public String getAddressee() {
		return addressee;
	}

	/**
	 * Establece el destinatario
	 * 
	 * @param addressee
	 */
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	/**
	 * Devuelve la dirección de entrega
	 * 
	 * @return
	 */
	@Column(name = "DELIVERY_ADDRESS")
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Establece la dirección de entrega
	 * 
	 * @param deliveryAddress
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * Devuelve si el pedido está dentro o fuera de la península
	 * 
	 * @return
	 */
	@Column(name = "IS_IN_PENINSULA")
	@NonNull
	public Boolean getIsInPeninsula() {
		return isInPeninsula;
	}

	/**
	 * Establece si el pedido está dentro o fuera de la península
	 * 
	 * @param peninsula
	 */
	public void setIsInPeninsula(Boolean isInPeninsula) {
		this.isInPeninsula = isInPeninsula;
	}

	/**
	 * Devuelve la lista de productos
	 * 
	 * @return
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
	public List<Product> getProduct() {
		return products;
	}

	/**
	 * Establece la lista de productos
	 * 
	 * @param product
	 */
	public void setProduct(List<Product> product) {
		this.products = product;
	}

	@Transient
	public Class<?> getClase() {
		return Order.class;
	}

}

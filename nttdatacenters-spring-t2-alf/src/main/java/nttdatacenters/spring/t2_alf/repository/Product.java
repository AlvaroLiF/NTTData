package nttdatacenters.spring.t2_alf.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;

/**
 * Taller Práctico 2 - Spring
 * 
 * Entidad de la tabla Product
 * 
 * @author ALF
 * 
 */

@Entity
@Table(name = "NTTDATA_PRODUCT")
public class Product implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long productId;

	/** Nombre del producto */
	private String name;

	/** Precio de venta al público */
	private Double retailPrice;

	/** Precio con impuestos */
	private Double priceWithTax;

	/** Pedido asociado */
	private Order order;

	/**
	 * Devuelve el Id del producto
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	public Long getProductId() {
		return productId;
	}

	/**
	 * Establece el Id del producto
	 * 
	 * @param productId
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Devuelve el nombre del producto
	 * 
	 * @return
	 */
	@Column(name = "NAME")
	@NonNull
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del producto
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve el precio de venta al público
	 * 
	 * @return
	 */
	@Column(name = "RETAIL_PRICE")
	@NonNull
	public Double getRetailPrice() {
		return retailPrice;
	}

	/**
	 * Establece el precio de venta al público
	 * 
	 * @param retailPrice
	 */
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * Devuelve el precio con impuestos
	 * 
	 * @return
	 */
	@Column(name = "PRICE_WITH_TAX")
	@NonNull
	public Double getPriceWithTax() {
		return priceWithTax;
	}

	/**
	 * Establece el precio con impuestos
	 * 
	 * @param priceWithTax
	 */
	public void setPriceWithTax(Double priceWithTax) {
		this.priceWithTax = priceWithTax;
	}

	/**
	 * Devuelve el pedido asociado
	 * 
	 * @return
	 */
	@ManyToOne
	public Order getOrder() {
		return order;
	}

	/**
	 * Establece el pedido asociado
	 * 
	 * @param order
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	@Transient
	public Class<?> getClase() {
		return Product.class;
	}

}

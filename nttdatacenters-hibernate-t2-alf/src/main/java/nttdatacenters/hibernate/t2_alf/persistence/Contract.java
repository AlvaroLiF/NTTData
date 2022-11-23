package nttdatacenters.hibernate.t2_alf.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Taller Práctico 2 - Hibernate
 * 
 * Entidad de tabla Contract
 * 
 * @author ALF
 *
 */

@Entity
@Table(name = "NTTDATA_CONTRACT")
public class Contract implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Identificador (PK) */
	private Long contractId;
	
	/** Fecha de vigencia */
	private Date effectiveDate;
	
	/** Fecha de caducidad */
	private Date expirationDate;
	
	/** Precio mensual */
	private Double monthlyPrice;
	
	/** Cliente asociado */
	private Client client;

	/**
	 * Devuelve el Id del contrato
	 * 
	 * @return contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * Establece el Id del contrato
	 * 
	 * @param contractId
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * Devuelve la fecha de vigencia del contrato
	 * 
	 * @return effectiveDate
	 */
	@Column(name = "EFFECTIVE_DATE")
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Establece la fecha de vigencia del contrato
	 * 
	 * @param effectiveDate
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Devuelve la fecha de caducidad del contrato
	 * 
	 * @return expirationDate
	 */
	@Column(name="EXPIRATION_DATE")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Establece la fecha de caducidad del contrato
	 * 
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Devuelve el precio mensual del contrato
	 * 
	 * @return monthlyPrice
	 */
	@Column(name="MONTHLY_PRICE")
	public Double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * Establece el precio mensual del contrato
	 * 
	 * @param monthlyPrice
	 */
	public void setMonthlyPrice(Double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * Establece la relación N:1 entre la tabla Contract y Client,
	 * entrando en la columna CLIENT_ID
	 * 
	 * @return client
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	/**
	 * Establece el cliente
	 * 
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * toString de la clase Contract
	 */
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", client=" + client + "]";
	}


	
	

}

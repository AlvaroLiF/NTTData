package nttdatacenters.hibernate.t3_alf.persistence;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * Entidad de la tabla Contract
 * 
 * @author ALF
 *
 */

@Entity
@Table(name = "NTTDATA_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de vigencia */
	private LocalDate effectiveDate;

	/** Fecha de caducidad */
	private LocalDate expirationDate;

	/** Precio mensual */
	private Double monthlyPrice;

	/** Cliente asociado */
	private Client client;

	/** Tipo de contrato asociado */
	private ContractType contractType;

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
	@Column(name = "EFFECTIVE_DATE", nullable = false)
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * Establece la fecha de vigencia del contrato
	 * 
	 * @param effectiveDate
	 */
	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * Devuelve la fecha de caducidad del contrato
	 * 
	 * @return expirationDate
	 */
	@Column(name = "EXPIRATION_DATE", nullable = false)
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Establece la fecha de caducidad del contrato
	 * 
	 * @param expirationDate
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Devuelve el precio mensual del contrato
	 * 
	 * @return monthlyPrice
	 */
	@Column(name = "MONTHLY_PRICE")
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
	 * Establece la relación N:1 entre la tabla Contract y Client, entrando en la
	 * columna CLIENT_ID
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
	 * Establece la relación 1:1 entre la tabla Contract y ContractType
	 * 
	 * @return contractType
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTRACT_TYPE_ID", referencedColumnName = "CONTRACT_TYPE_ID")
	public ContractType getContractType() {
		return contractType;
	}

	/**
	 * Establece el tipo de contrato
	 * 
	 * @param contractType
	 */
	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	/**
	 * toString de la clase Contract
	 */
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", effectiveDate=" + effectiveDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + ", client=" + client + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

}

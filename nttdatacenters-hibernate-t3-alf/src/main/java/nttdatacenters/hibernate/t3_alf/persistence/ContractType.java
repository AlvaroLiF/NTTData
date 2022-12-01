package nttdatacenters.hibernate.t3_alf.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Taller Práctico 3 - Hibernate
 * 
 * Entidad de la tabla ContractType
 * 
 * @author ALF
 * 
 */
@Entity
@Table(name = "NTTDATA_CONTRACT_TYPE")
public class ContractType extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractTypeId;

	/** Tipo de contrato */
	private String type;

	/** Porcentaje de impuestos */
	private Integer taxRate;

	/** Contrato asociado */
	private Contract contract;

	/**
	 * Devuelve el Id del tipo de contrato
	 * 
	 * @return contractTypeId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_TYPE_ID")
	public Long getContractTypeId() {
		return contractTypeId;
	}

	/**
	 * Establece el Id del tipo de contrato
	 * 
	 * @param contractTypeId
	 */
	public void setContractTypeId(Long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	/**
	 * Devuelve el tipo de contrato
	 * 
	 * @return type
	 */
	@Column(name = "CONTRACT_TYPE_NAME")
	public String getType() {
		return type;
	}

	/**
	 * Establece el tipo de contrato
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Devuelve el porcentaje de impuestos
	 * 
	 * @return taxRate
	 */
	@Column(name = "CONTRACT_TYPE_TAX_RATE")
	public Integer getTaxRate() {
		return taxRate;
	}

	/**
	 * Establece el porcentaje de impuestos
	 * 
	 * @param taxRate
	 */
	public void setTaxRate(Integer taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * Establece la relación 1:1 entre la tabla ContractType y Contract
	 * 
	 * @return contract
	 */

	@OneToOne(mappedBy = "contractType")
	public Contract getContract() {
		return contract;
	}

	/**
	 * Establece el contrato
	 * 
	 * @param contract
	 */
	public void setContract(Contract contract) {
		this.contract = contract;
	}

	/**
	 * toString de la clase ContractType
	 */
	@Override
	public String toString() {
		return "ContractType [contractTypeId=" + contractTypeId + ", type=" + type + ", taxRate=" + taxRate
				+ ", contract=" + contract + "]";
	}

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}
}

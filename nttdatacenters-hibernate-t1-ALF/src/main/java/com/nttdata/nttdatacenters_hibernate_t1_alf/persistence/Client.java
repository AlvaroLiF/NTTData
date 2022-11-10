package com.nttdata.nttdatacenters_hibernate_t1_alf.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Taller Práctico 1 - Hibernate
 * 
 * Entidad de tabla Client
 * 
 * @author ALF
 * 
 */

@Entity
@Table(name = "NTTDATA_CLIENT")
public class Client implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientId;

	/** Nombre del cliente */
	private String firstName;

	/** Primer apellido del cliente */
	private String firstSurname;

	/** Segundo apellido */
	private String secondSurname;

	/** Número de documento de identidad */
	private Integer identityCardNumber;

	/**
	 * Devuelve el Id del cliente
	 * 
	 * @return clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * Establece el Id del cliente
	 * 
	 * @param clientId
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * Devuelve el nombre
	 * 
	 * @return fisrtName
	 */
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Establece el nombre
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Devuelve el primer apellido
	 * 
	 * @return firstSurname
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * Establece el primer apellido
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido
	 * 
	 * @return secondSurname
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * Establece el segundo apellido
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * Devuelve el número del documento de identidad
	 * 
	 * @return identityCardNumber
	 */
	@Column(name = "IDENTITY_CARD_NUMBER", nullable = false, unique = true)
	@Size(max = 9)
	public Integer getIdentityCardNumber() {
		return identityCardNumber;
	}

	/**
	 * Establece el número del documento de identidad
	 * 
	 * @param identityCardNumber
	 */
	public void setIdentityCardNumber(Integer identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", identityCardNumber=" + identityCardNumber + "]";
	}

}

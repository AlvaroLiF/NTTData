package nttdatacenters.spring.t3_alf.repository;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

/**
 * Taller Práctico 3 - Spring
 * 
 * Entidad de la tabla Client
 * 
 * @author ALF
 * 
 */

@Entity
@Table(name = "NTTDATA_CLIENT")
public class Client implements Serializable {

	/** Serial version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientId;

	/** Nombre del cliente */
	private String name;

	/** Apellidos del cliente */
	private String surnames;

	/** Fecha de nacimiento */
	private LocalDate birthdate;

	/** Número del documento de identidad */
	private Integer identityCardNumber;

	/**
	 * Devuelve el Id del cliente
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * Establece el Id del ciente
	 * 
	 * @param clientId
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * Devuelve el nombre del cliente
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
	 * Devuelve los apellidos del cliente
	 * 
	 * @return
	 */
	@Column(name = "SURNAMES")
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Establece los apellidos del cliente
	 * 
	 * @param surnames
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * Devuelve la fecha de nacimiento
	 * 
	 * @return
	 */
	@Column(name = "BIRTHDATE")
	@DateTimeFormat
	@NonNull
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * Establece la fecha de nacimiento
	 * 
	 * @param birthdate
	 */
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Devuelve el número del documento de identidad
	 * 
	 * @return
	 */
	@Column(name = "IDENTITY_CARD_NUMBER", unique = true, length = 9)
	@NonNull
	@NumberFormat
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

	@Transient
	public Class<?> getClase() {
		return Client.class;
	}

}

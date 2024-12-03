package com.example.pawpalandiaDB.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "services")
public class ServiceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serviceOrder")
    private Long idServiceOrder;

    @Column(name = "client_name", length = 50, nullable = false, unique = false)
    private String clientName;
    
    @Column(name = "pet_name", length = 50, nullable = false, unique = false)
    private String petName; 
    
    @Column(name = "breed", length = 50, nullable = false, unique = false)
    private String breed; 

    @Column(name = "email", length = 50, nullable = false, unique = false)
    private String email;

    @Column(name = "phone_number", length = 15, nullable = false, unique = false)
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "date", nullable = false, unique = true)
    private Date date; 

    @Column(name = "kind_of_service", length = 50, nullable = false, unique = false)
    private String kindOfService;

    @Column(name = "comment", length = 500, nullable = true, unique = false)
    private String comment;

    @Column(name = "privacy_policy_accepted", nullable = false, unique = false)
    private Boolean privacyPolicyAccepted;
    
    //Constructor JPA
    public ServiceEntity() {

    }

    //Constructor
    public ServiceEntity(Long idServiceOrder, String clientName, String petName, String breed, String email,
			String phoneNumber, Date date, String kindOfService, String comment, Boolean privacyPolicyAccepted) {
		this.idServiceOrder = idServiceOrder;
		this.clientName = clientName;
		this.petName = petName;
		this.breed = breed;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.date = date;
		this.kindOfService = kindOfService;
		this.comment = comment;
		this.privacyPolicyAccepted = privacyPolicyAccepted;
	}

	//Getters and setters
    public Long getIdServiceOrder() {
		return idServiceOrder;
	}

	public void setIdServiceOrder(Long idServiceOrder) {
		this.idServiceOrder = idServiceOrder;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getKindOfService() {
		return kindOfService;
	}

	public void setKindOfService(String kindOfService) {
		this.kindOfService = kindOfService;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getPrivacyPolicyAccepted() {
		return privacyPolicyAccepted;
	}

	public void setPrivacyPolicyAccepted(Boolean privacyPolicyAccepted) {
		this.privacyPolicyAccepted = privacyPolicyAccepted;
	}

	// toString()
	@Override
	public String toString() {
		return "ServiceEntity [idServiceOrder=" + idServiceOrder + ", clientName=" + clientName + ", petName=" + petName
				+ ", breed=" + breed + ", email=" + email + ", phoneNumber=" + phoneNumber + ", date=" + date
				+ ", kindOfService=" + kindOfService + ", comment=" + comment + ", privacyPolicyAccepted="
				+ privacyPolicyAccepted + "]";
	}

    // hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(breed, clientName, comment, date, email, idServiceOrder, kindOfService, petName,
				phoneNumber, privacyPolicyAccepted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceEntity other = (ServiceEntity) obj;
		return Objects.equals(breed, other.breed) && Objects.equals(clientName, other.clientName)
				&& Objects.equals(comment, other.comment) && Objects.equals(date, other.date)
				&& Objects.equals(email, other.email) && Objects.equals(idServiceOrder, other.idServiceOrder)
				&& Objects.equals(kindOfService, other.kindOfService) && Objects.equals(petName, other.petName)
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(privacyPolicyAccepted, other.privacyPolicyAccepted);
	}



    

}

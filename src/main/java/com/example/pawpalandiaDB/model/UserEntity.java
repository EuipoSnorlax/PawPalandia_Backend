package com.example.pawpalandiaDB.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
    private Long idUser;

    @Column(name = "name", length = 20, nullable = false,  unique = false)
    private String name;

    @Column(name = "middle_name", length = 20, nullable = false, unique = false)
    private String middleName;

    @Column(name = "last_name", length = 20, nullable = false, unique = false)
    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birth_day", nullable = false, unique = false)
    private Date birthDay; 

    @Column(name = "phone_number", length = 15, nullable = false, unique = false)
    private String phoneNumber;

    @Column(name = "email", length = 50, nullable = false,  unique = true)
    private String email;

    @Column(name = "password", length = 50, nullable = false, unique = false)
    private String password;

    @Column(name = "is_vip", nullable = false, unique = false)
    private Boolean isVip;

    @Column(name = "privacy_policy_accepted", nullable = false, unique = false)
    private Boolean privacyPolicyAccepted;

    //Constructor JPA
    public UserEntity() {

    }

    //Constructor
    public UserEntity(Long idUser, String name, String middleName, String lastName, Date birthDay, String phoneNumber,
            String email, String password, Boolean isVip, Boolean privacyPolicyAccepted) {
        this.idUser = idUser;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.isVip = isVip;
        this.privacyPolicyAccepted = privacyPolicyAccepted;
    }

    //Getters and setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsVip() {
        return isVip;
    }

    public void setIsVip(Boolean isVip) {
        this.isVip = isVip;
    }

    public Boolean getPrivacyPolicyAccepted() {
        return privacyPolicyAccepted;
    }

    public void setPrivacyPolicyAccepted(Boolean privacyPolicyAccepted) {
        this.privacyPolicyAccepted = privacyPolicyAccepted;
    }

    //toString
    @Override
    public String toString() {
        return "UserEntity [idUser=" + idUser + ", name=" + name + ", middleName=" + middleName + ", lastName="
                + lastName + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber + ", email=" + email
                + ", password=" + password + ", isVip=" + isVip + ", privacyPolicyAccepted=" + privacyPolicyAccepted
                + "]";
    }

    //hashCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((isVip == null) ? 0 : isVip.hashCode());
        result = prime * result + ((privacyPolicyAccepted == null) ? 0 : privacyPolicyAccepted.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEntity other = (UserEntity) obj;
        if (idUser == null) {
            if (other.idUser != null)
                return false;
        } else if (!idUser.equals(other.idUser))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (middleName == null) {
            if (other.middleName != null)
                return false;
        } else if (!middleName.equals(other.middleName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (birthDay == null) {
            if (other.birthDay != null)
                return false;
        } else if (!birthDay.equals(other.birthDay))
            return false;
        if (phoneNumber == null) {
            if (other.phoneNumber != null)
                return false;
        } else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (isVip == null) {
            if (other.isVip != null)
                return false;
        } else if (!isVip.equals(other.isVip))
            return false;
        if (privacyPolicyAccepted == null) {
            if (other.privacyPolicyAccepted != null)
                return false;
        } else if (!privacyPolicyAccepted.equals(other.privacyPolicyAccepted))
            return false;
        return true;
    }
    
    
    
    

    


    
}



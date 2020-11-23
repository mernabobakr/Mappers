package com.kidzona.parentsservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.dozer.Mapping;

import java.util.Set;

@Entity
@Table(name = "parents")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"},ignoreUnknown = true)
public class Parent {
	@Mapping("id")
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
	@Mapping("firstName")
    @Column(name = "first_name")
    @NotNull(message = "first name should be provided")
    @NotEmpty(message = "first name can not be empty")
    private String firstName;
	@Mapping("lastName")
    @Column(name = "last_name")
    @NotNull(message = "last name should be provided")
    @NotEmpty(message = "last name can not be empty")
    private String lastName;
	@Mapping("address")
    @Column(name = "address")
    @NotNull(message = "address should be provided")
    @NotEmpty(message = "address can not be empty")
    private String address;
	@Mapping("pictureUrl")
    @Column(name = "picture_url")
    private String pictureUrl;
	@Mapping("email")
    @Column(name = "email",unique=true)
    @NotNull(message = "an Email should be provided")
    @Email(message = "Not a valid email")
    private String email;
    @JsonManagedReference
    @OneToMany(mappedBy = "parent")
    private Set<Kid> kids;

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

   

    
}

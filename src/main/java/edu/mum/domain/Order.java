package edu.mum.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity 
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
	
	@Column(length = 16)
	@NotEmpty(message= "{String.empty}")
	private String firstName;
	
	@Column(length = 16)
	@Size(min=6, max = 16, message= "{Size.name.validation}")
	private String lastName;

	private LocalDate time;
 	

	@Size(min=6, max = 255, message= "{Size.name.validation}")
	private String address;


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public LocalDate getTime() {
		return time;
	}


	public void setTime(LocalDate time) {
		this.time = time;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
}


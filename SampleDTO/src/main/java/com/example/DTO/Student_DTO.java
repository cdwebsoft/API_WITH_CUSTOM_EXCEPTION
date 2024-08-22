package com.example.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Student_DTO {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   @NotNull
   String user_name;
   String email;
   String Address;
public Student_DTO() {
	super();
		
}
public Student_DTO(int id, @NotNull String user_name, String email, String address) {
	super();
	this.id = id;
	this.user_name = user_name;
	this.email = email;
	Address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
@Override
public String toString() {
	return "Student_DTO [id=" + id + ", user_name=" + user_name + ", email=" + email + ", Address=" + Address + "]";
}
   
   
   
}

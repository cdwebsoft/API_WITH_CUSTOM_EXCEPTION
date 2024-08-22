package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String email;
   String Address;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String name, String email, String address) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	Address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", Address=" + Address + "]";
}
     
  
     
}

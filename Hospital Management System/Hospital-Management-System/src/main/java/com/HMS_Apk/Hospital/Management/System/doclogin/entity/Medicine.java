package com.HMS_Apk.Hospital.Management.System.doclogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicines")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicineId")
	private long medicineId;

	@Column(name = "drugname")
	private String name;

	@Column(name = "quantity")
    private int quantity;
	
	
	@Column(name = "price")
	private double price;

	@Column(name = "expiryDate")
    private String expiryDate;


	public long getMedicineId() {
		return medicineId;
	}


	public void setMedicineId(long id) {
		this.medicineId = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Medicine() {
		// TODO Auto-generated constructor stub
	}


	public Medicine(long id, String name, int quantity, double price, String expiryDate) {
		super();
		this.medicineId = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
	}

	

}

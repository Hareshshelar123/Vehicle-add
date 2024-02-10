package com.vehicle.management.bean;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity

@Table(name = "vehicle")
@Data
@Audited
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique = true)
	private String vehicleRegistrationNumber;
	private String ownername;
	private String brand;
	private LocalDateTime registrationExpires;
	private boolean isActive;
	private String createdby;
	@CreationTimestamp
	private LocalDateTime creationtime;
	private String modifiedby;
	@UpdateTimestamp
	private LocalDateTime modifiedtime;

}

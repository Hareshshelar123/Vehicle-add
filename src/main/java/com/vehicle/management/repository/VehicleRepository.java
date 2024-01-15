package com.vehicle.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.management.bean.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

//	public boolean FindByVehicleRegistrationNumber(String RegistrationNumber);

}

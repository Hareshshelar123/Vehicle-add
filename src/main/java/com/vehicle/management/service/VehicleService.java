package com.vehicle.management.service;

import java.util.List;

import com.vehicle.management.bean.Vehicle;

import com.vehicle.management.dto.VehicleDto;
import com.vehicle.management.exception.DuplicateFieldException;
import com.vehicle.management.payload.ApiResponse;


public interface VehicleService {

	ApiResponse<VehicleDto> saveVehicle(VehicleDto vehicleDto) ;
	

	ApiResponse<VehicleDto> getVehicleById( long id);

	List<VehicleDto> getAllVehicles(Integer pageNumber,Integer pageSize);

	ApiResponse<VehicleDto> updateVehicle(long id, VehicleDto vehicleDto);

	ApiResponse<VehicleDto> deleteVehicle(long id);
	
	String  getVehiclebyTemplet();


}

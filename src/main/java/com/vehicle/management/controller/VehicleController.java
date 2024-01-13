package com.vehicle.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.management.dto.VehicleDto;
import com.vehicle.management.payload.ApiResponse;
import com.vehicle.management.service.VehicleService;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")

public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	


    
	@PostMapping("/addVehicle")
	public ApiResponse<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {
		return vehicleService.saveVehicle(vehicleDto);
	}
 
	
	@GetMapping("/getVehicle/{id}")
	public ApiResponse<VehicleDto> getVehicle(@PathVariable("id") long id) {
		return vehicleService.getVehicleById(id);
	}

	
	@GetMapping("/getAllVehicle")
	public ResponseEntity<List<VehicleDto>> getAllVehicle(
			@RequestParam(value="pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "10",required = false) Integer pageSize
			) {
		
		//List<Vehicle> vehicle = vehicleService.getAllVehicles();
		return new ResponseEntity<List<VehicleDto>>(vehicleService.getAllVehicles(pageNumber,pageSize),HttpStatus.OK);
	}

	
	@PutMapping("/updateVehicle/{id}")
	public ApiResponse<VehicleDto> updateVehicle(@PathVariable long id, @RequestBody VehicleDto vehicleDto) {
	//	VehicleDto updated = vehicleService.updateVehicle(id, vehicleDto);
		
			return vehicleService.updateVehicle(id, vehicleDto);
		}
	

	
	@DeleteMapping("/deletevehicle/{id}")
	public ApiResponse<VehicleDto> deleteVehicle(@PathVariable long id) {
		vehicleService.deleteVehicle(id);
		return vehicleService.deleteVehicle(id);
	}
	
	@GetMapping("/getvehicletemp")
	public String getVehicleTemp() {
		//vehicleService.getVehiclebyTemplet(id);
		return vehicleService.getVehiclebyTemplet();
	}

	// public List<Vehicle> getAllVehicle();

	// public void updateVehicle(@PathVariable long id,@RequestBody Vehicle
	// updatVehicle);

	// public void deleteVehicle(@PathVariable long id,@RequestBody Vehicle
	// vehicle);

//	@Autowired
//	private VehicleService vehiclesservice;
//
//	@GetMapping("/vehicle")
//	public List<Vehicle> getAllVehicle() {
//		return vehiclesservice.getAllVehicle();
//
//	}
//     @PostMapping("/addvehicle")
//	public void addVehicle(@RequestBody Vehicle vehicle) {
//		vehiclesservice.addVehicle(vehicle);
//	}
//
//	@PutMapping("/updatevehicle/{id}")
//	public void updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
//		vehiclesservice.updatevehicle(vehicle);
//	}
//
//	@DeleteMapping("/deletevehicle/{id}")
//	public void deleteVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
//		vehiclesservice.deletevehicle(vehicle);

}

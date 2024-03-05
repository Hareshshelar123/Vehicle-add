package com.vehicle.management.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import com.vehicle.management.bean.Vehicle;
import com.vehicle.management.dto.VehicleDto;

@Mapper(componentModel="spring")
public interface VehicleMapper {
	
	
	
	Vehicle mapVehicleDtoToVehicle(VehicleDto vehicledto);
	
	VehicleDto mapVehicleToVehicleDto(Vehicle vehicle);
	
	List<VehicleDto> mapVehicleListToVehicleDtoList(List<Vehicle> vehicle);
	
	
	

}

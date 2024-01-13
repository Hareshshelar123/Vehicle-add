package com.vehicle.management.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vehicle.management.bean.Vehicle;
import com.vehicle.management.dto.VehicleDto;
import com.vehicle.management.exception.ResourceNotFoundException;
import com.vehicle.management.mapper.VehicleMapper;
import com.vehicle.management.payload.ApiResponse;
import com.vehicle.management.repository.VehicleRepository;

@Service
@Component
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ApiResponse<VehicleDto> saveVehicle(VehicleDto vehicleDto) {
		try {
			

			Vehicle vehicle = vehicleMapper.mapVehicleDtoToVehicle(vehicleDto);
			VehicleDto vehicleDto1 = vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(vehicle));
			return new ApiResponse<VehicleDto>(vehicleDto1, null, null, "vehicle added successflly", HttpStatus.OK,
					true);
			// Vehicle saveVehicle=vehicleRepository.save(vehicle);
			// return vehicleMapper.mapVehicleToVehicleDto(saveVehicle);

		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal server Error", HttpStatus.NOT_FOUND, false);

		}

	}

	@Override
	public ApiResponse<VehicleDto> getVehicleById(long id) {
		
		try {
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", id));
         VehicleDto vehicleDto=vehicleMapper.mapVehicleToVehicleDto(vehicle);
		return new ApiResponse<VehicleDto>(vehicleDto, null, null, "Vehicle data", HttpStatus.OK, false);

	}
		catch (ResourceNotFoundException ex) {
			return new ApiResponse<VehicleDto>(null, null, null, ex.getMessage(), HttpStatus.NOT_FOUND, true);
		}
		catch(Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, false);
		}
		
		}

	@Override
	public List<VehicleDto> getAllVehicles(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<Vehicle> pagepost = vehicleRepository.findAll(p);
		List<Vehicle> vehicle = pagepost.getContent();

		return vehicleMapper.mapVehicleListToVehicleDtoList(vehicle);
	}

	@Override
	public ApiResponse<VehicleDto> updateVehicle(long id, VehicleDto vehicleDto) {
		
		try {

		Vehicle existingvehicle = vehicleRepository.findById(id).orElse(null);

		existingvehicle.setOwnername(vehicleDto.getOwnername());
		existingvehicle.setBrand(vehicleDto.getBrand());
		existingvehicle.setRegistrationExpires(vehicleDto.getRegistrationExpires());
		existingvehicle.setCreatedby(vehicleDto.getCreatedby());
		existingvehicle.setCreationtime(vehicleDto.getCreationtime());
		existingvehicle.setModifiedby(vehicleDto.getModifiedby());
        
		VehicleDto vehicleDto2=vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(existingvehicle)) ;
		return new ApiResponse<VehicleDto>(vehicleDto2, null, null, "vehicle update sccessfully", HttpStatus.OK, false);
		}
		catch (ResourceNotFoundException ex) {
			return new ApiResponse<VehicleDto>(null, null, null, ex.getMessage(), HttpStatus.NOT_FOUND, false);
		}
		catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "value not present", HttpStatus.NOT_FOUND, true);
			// TODO: handle exception
		}

	}

	@Override
	public ApiResponse<VehicleDto> deleteVehicle(long id) {
		
		try {
			vehicleRepository.deleteById(id);
			return new ApiResponse<VehicleDto>(null, null, null, "vehicle delete successfully", HttpStatus.OK, false);

		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "value not found ", HttpStatus.NOT_FOUND, true);
			
		}
	
	}

	@Override
	public String getVehiclebyTemplet() {
		
		try {
			HttpHeaders headers =new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String > entity =new HttpEntity<String>(headers);
			ResponseEntity<String> templateData = restTemplate.exchange("https://jsonplaceholder.typicode.com/todos/1", HttpMethod.GET, entity, String.class, headers);
			
			return templateData.getBody();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return null;
	}
	
	
	

}

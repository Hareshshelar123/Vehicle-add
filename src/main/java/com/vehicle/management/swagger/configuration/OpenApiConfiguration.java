package com.vehicle.management.swagger.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
		info = @Info(
				title="Vehicle management",
				description ="Doing crud opertion"
				)
		
		)

@SecurityScheme(name = "myapi", 
scheme = "basic", 
type = SecuritySchemeType.HTTP, 
in = SecuritySchemeIn.HEADER)

public class OpenApiConfiguration {

}

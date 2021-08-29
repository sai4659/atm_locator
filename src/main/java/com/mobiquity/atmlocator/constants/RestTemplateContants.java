package com.mobiquity.atmlocator.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Configuration
@Component
public class RestTemplateContants {

	@Value("${atm.endpoint}")
	private String atmEndPoint;
	
	@Value("${atm.url}")
	private String url;

	
}

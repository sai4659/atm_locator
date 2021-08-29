package com.mobiquity.atmlocator.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.mobiquity.atmlocator.constants.RestTemplateContants;
import com.mobiquity.atmlocator.model.Atm;

/**
 * 
 * @author saikrishna
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {

	@InjectMocks
	AtmService atmService;

	@Mock
	RestTemplateContants constants;

	@Mock
	private RestTemplate restTemplate;

	@Test
	@DisplayName("Get All Atm list")
	public void getAll() throws IOException {
		System.out.println(constants.getUrl());
		String response = new String(
				"[)]}',{\"address\":{\"street\":\"Schoolstraat\",\"housenumber\":\"1\",\"postalcode\":\"2251 BD\",\"city\":\"Voorschoten\",\"geoLocation\":{\"lat\":\"52.126524\",\"lng\":\"4.448693\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"10:00\",\"hourTo\":\"20:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"},{\"address\":{\"street\":\"Bautscherweg\",\"housenumber\":\"21-25\",\"postalcode\":\"6418 EJ\",\"city\":\"Heerlen\",\"geoLocation\":{\"lat\":\"50.86761\",\"lng\":\"6.00551\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"}]");
		when(constants.getUrl()).thenReturn("/atms/");
		when(constants.getAtmEndPoint()).thenReturn("https://www.ing.nl/api/locator");
		when(restTemplate.getForObject(constants.getUrl() + constants.getAtmEndPoint(), String.class))
				.thenReturn(response);
		List<Atm> atmLocators = atmService.getAllAtmLocators(null);
		assertNotNull(atmLocators);
		assertTrue(atmLocators.size() == 2);
	}

	@Test
	@DisplayName("Get All atm by city")
	public void getByCity() throws IOException {

		String response = new String(
				"[)]}',{\"address\":{\"street\":\"Schoolstraat\",\"housenumber\":\"1\",\"postalcode\":\"2251 BD\",\"city\":\"Voorschoten\",\"geoLocation\":{\"lat\":\"52.126524\",\"lng\":\"4.448693\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"08:00\",\"hourTo\":\"21:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"10:00\",\"hourTo\":\"20:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"},{\"address\":{\"street\":\"Bautscherweg\",\"housenumber\":\"21-25\",\"postalcode\":\"6418 EJ\",\"city\":\"Heerlen\",\"geoLocation\":{\"lat\":\"50.86761\",\"lng\":\"6.00551\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"}]");
		when(constants.getUrl()).thenReturn("/atms/");
		when(constants.getAtmEndPoint()).thenReturn("https://www.ing.nl/api/locator");
		when(restTemplate.getForObject(constants.getUrl() + constants.getAtmEndPoint(), String.class))
				.thenReturn(response);
		List<Atm> atmLocators = atmService.getAllAtmLocators("Heerlen");

		assertNotNull(atmLocators);

		assertTrue(atmLocators.size() == 1);
	}
}

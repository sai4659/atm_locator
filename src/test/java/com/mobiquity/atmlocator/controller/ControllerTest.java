package com.mobiquity.atmlocator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.mobiquity.atmlocator.model.Address;
import com.mobiquity.atmlocator.model.Atm;
import com.mobiquity.atmlocator.service.AtmService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
	
	@InjectMocks
	private Controller controller;
	

	@Mock
	AtmService atmService;
	
	
	@Test
	@DisplayName("Get All atm controller")
	public void getAllAtmsController() throws IOException {
		List<Atm> list = new ArrayList<Atm>();
		list.add(new Atm());
		when(atmService.getAllAtmLocators(Mockito.any())).thenReturn(list);
		ResponseEntity<List<Atm>> atmLocators =  controller.getAll(null);
		assertNotNull(atmLocators);
		assertTrue(atmLocators.getBody().size()!=0);
	}

	@Test
	@DisplayName("Get All atm controller with city")
	public void getAllAtmsControllerWithCity() throws IOException {
		List<Atm> list = new ArrayList<Atm>();
		Atm atm = new Atm();
		Address address = new Address();
		address.setCity("Hyderabad");
		atm.setAddress(address);
		list.add(atm);
		when(atmService.getAllAtmLocators(Mockito.anyString())).thenReturn(list);
		ResponseEntity<List<Atm>> atmLocators =  controller.getAll("Hyderabad");
		assertNotNull(atmLocators);
		assertTrue(atmLocators.getBody().size()!=0);
	}
}

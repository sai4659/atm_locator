package com.mobiquity.atmlocator.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mobiquity.atmlocator.model.Atm;
import com.mobiquity.atmlocator.service.AtmService;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author saikrishna
 *
 */
@WebMvcTest
public class EndpointTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AtmService service;

	@Test
	public void getAllEndpoint() throws Exception {
		List<Atm> list = new ArrayList<Atm>();
		Atm atm = new Atm();
		atm.setType("listType");
		list.add(atm);
		when(service.getAllAtmLocators(null)).thenReturn(list);
		this.mockMvc.perform(get("/getAll")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
	}
	
	@Test
	public void getAllEndpointNotFound() throws Exception {
		List<Atm> list = new ArrayList<Atm>();
		Atm atm = new Atm();
		atm.setType("listType");
		list.add(atm);
		when(service.getAllAtmLocators(null)).thenReturn(list);
		this.mockMvc.perform(get("/getAllA")).andDo(print()).andExpect(status().isNotFound());
	}
	

}

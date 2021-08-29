package com.mobiquity.atmlocator.service;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.atmlocator.constants.RestTemplateContants;
import com.mobiquity.atmlocator.model.Atm;

@Service
public class AtmService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RestTemplateContants constants;

	@Cacheable(value = "atms")
	public List<Atm> getAllAtmLocators(String city) throws IOException {
		try {
			String object = restTemplate.getForObject(constants.getUrl() + constants.getAtmEndPoint(), String.class);
			object = object.replace(")]}',", "");
			ObjectMapper objectMapper = new ObjectMapper();
			List<Atm> atms = objectMapper.readValue(object, new TypeReference<List<Atm>>() {
			});
			if (!StringUtils.hasText(city)) {
				return atms;
			}
			return atms.stream().filter(each -> each.getAddress().getCity().equalsIgnoreCase(city))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}
}

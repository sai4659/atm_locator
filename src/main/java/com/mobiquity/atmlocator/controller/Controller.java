package com.mobiquity.atmlocator.controller;

import java.io.IOException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.mobiquity.atmlocator.constants.URLMappingConstants;
import com.mobiquity.atmlocator.error.ErrorMessage;
import com.mobiquity.atmlocator.model.Atm;
import com.mobiquity.atmlocator.service.AtmService;

@RestController
public class Controller {
	
	private final static  Logger log = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private AtmService atmService;

	@GetMapping(value = {URLMappingConstants.GET_ALL,URLMappingConstants.GET_ALL+"/{city}"})
	public ResponseEntity<List<Atm>> getAll(@PathVariable(required = false) String city ) {
		try {
			return new ResponseEntity<List<Atm>>(atmService.getAllAtmLocators(city), HttpStatus.OK);
		} catch (IOException e) {
			log.error("Error while getting atm list : {}",e.getMessage());
			return new ResponseEntity(new ErrorMessage("400","Bad Request"),HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			log.error("Internal Server Error: {}",e.getMessage());
			return new ResponseEntity(new ErrorMessage("500","Something went wrong please try afte sometime"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

package com.mobiquity.atmlocator.model;

import java.util.List;

import lombok.Data;

@Data
public class Atm {

	private Address address;
	private Integer distance;
	private List<OpeningHours> openingHours;
	private String functionality;
	private String type;

}

package com.mobiquity.atmlocator.model;

import lombok.Data;

@Data
public class Address {

	private String street;
	private String housenumber;
	private String postalcode;
	private String city;
	private GeoLocation geoLocation;

}

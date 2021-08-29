package com.mobiquity.atmlocator.model;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OpeningHours {

	private Integer dayOfWeek;
	
	private List<Hours> hours;
}

@Data
@NoArgsConstructor
class Hours {
	
	private String hourFrom;
	
	private String hourTo;
}
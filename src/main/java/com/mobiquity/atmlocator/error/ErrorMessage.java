package com.mobiquity.atmlocator.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	
	private String errorCode;
	
	private String errorMessage;

}

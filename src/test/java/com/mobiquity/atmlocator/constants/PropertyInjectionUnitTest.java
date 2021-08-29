package com.mobiquity.atmlocator.constants;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.mobiquity.atmlocator.constants.RestTemplateContants;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyInjectionUnitTest {
	
    @Autowired 
    private RestTemplateContants restTemplateContants;

	@Test
    public void whenPropertyProvided_thenProperlyInjected() {
        assertEquals(restTemplateContants.getAtmEndPoint(), "/atms/");
        assertEquals(restTemplateContants.getUrl(), "https://www.ing.nl/api/locator");
    }

}

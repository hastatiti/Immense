package com.immense.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.immense.service.RandomNumberService;

@RunWith(SpringRunner.class)
@WebMvcTest(NumberController.class)
public class NumberControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RandomNumberService randomNumberService;
	
	int random;
	
	@Before
	public void setUp() {
		random = new RandomNumberService().getRandomNumber();
	 
	    Mockito.when(randomNumberService.getRandomNumber())
	      .thenReturn(random);
	}
	
	@Test
	public void shouldReturnNumberFromService() throws Exception{
		this.mockMvc.perform(get("/LotteryNumber")
		.accept("application/json"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.model().size(1))
		.andExpect(MockMvcResultMatchers.model().attributeExists("LotteryNumber"))
		.andExpect(MockMvcResultMatchers.model().attribute("LotteryNumber", random));
	}
}

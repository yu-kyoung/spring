package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ExControllerTest.class)
public class ExControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testList() throws Exception {
//	    UserVO userVO = new UserVO(); 
//	    userVO.setName("마이콜"); 
//	    userVO.setAge(20); 
//	 
//	    String jsonStr = new ObjectMapper().writeValueAsString(reply); 

		String result = mvc.perform(get("/api/rest2")
				//.param("age", "10")
				//.param("name", "kim")
				)
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);

	}
}
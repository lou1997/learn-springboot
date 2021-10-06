package com.lyd.learnspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTestDemo {
 @Autowired
    private MockMvc mockMvc;

 @Test
    public void apiTest() throws Exception{
     MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/test/home")).
             andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    int status =mvcResult.getResponse().getStatus();
    System.out.println(status);

 }
}

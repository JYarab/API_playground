package com.jy.api_testing.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jy.api_testing.models.Drink;



@Controller
public class SearchController {

	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping("")
	public String drinkSearch(@RequestParam(required = false, value="search") String search, @RequestParam(required = false, value="mainAlch") String mainAlch, Model viewModel) throws JsonMappingException, JsonProcessingException {
		
		if(search != null) {
			RestTemplate restTemplate = new RestTemplate();			
			String resp = restTemplate.getForObject("https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=" + mainAlch, String.class);
			System.out.println(resp); 
			final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			final JsonNode jsonNode = objectMapper.readTree(resp);
			System.out.println(jsonNode);
			final JsonNode result = jsonNode.get("drinks");
			System.out.println(result);

			final Drink[] resultList = objectMapper.treeToValue(result, Drink[].class);
		
			System.out.println(resultList);
			viewModel.addAttribute("drinkList", resultList);
		}
		
		
		
		return "search.jsp";
	}
	
	
	@GetMapping("/test")
	public String testRoute() {
		return "test.jsp";
	}
	
}

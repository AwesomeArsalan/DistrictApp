package com.springjpa.freelancetask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.freelancetask.entity.Circle;
import com.springjpa.freelancetask.entity.District;
import com.springjpa.freelancetask.service.CircleService;
import com.springjpa.freelancetask.service.DistrictService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {

	@Autowired
	private CircleService circleService;
	
	@Autowired
	private DistrictService districtService;
	
	@GetMapping("/home")
	public String welcome() {
		return "welcome to spring data jpa";
	}
	
	/*
	 * To fetch list of circles
	 */
	@GetMapping("/circle")
	public List<Circle> getCircles(){
		return circleService.getCircles();	
	}
	
	/*
	 * To fetch list of circles by district name
	 */
	@GetMapping("/circle/{districtName}")
	public List<Circle> getDistrictsByDivision(@PathVariable String districtName){
		return circleService.getCircleByDistrictName(districtName);	
	}
	
	/*
	 * To save list of circles
	 */
	@PostMapping("/circle")
	public boolean addCircle(@RequestBody List<Circle> circleList) {
		return circleService.addCircle(circleList);
	}
	
	/*
	 * To fetch list of districts
	 */
	@GetMapping("/district")
	public List<District> getDistrict(){
		return districtService.getDistrict();	
	}
	
	/*
	 * To save list of districts
	 */
	@PostMapping("/district")
	public boolean addDistrict(@RequestBody List<District> district) {
		return districtService.addDistrict(district);
	}
}

package com.springjpa.freelancetask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.freelancetask.entity.Circle;

public interface CircleRepository extends JpaRepository<Circle, Integer> {

	List<Circle> findByDistrictName(String districtName);
	
}

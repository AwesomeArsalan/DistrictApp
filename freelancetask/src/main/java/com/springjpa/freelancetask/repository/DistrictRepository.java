package com.springjpa.freelancetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.freelancetask.entity.District;

public interface DistrictRepository extends JpaRepository<District, Integer> {
	
}

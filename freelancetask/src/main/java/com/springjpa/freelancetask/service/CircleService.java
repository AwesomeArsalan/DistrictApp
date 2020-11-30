package com.springjpa.freelancetask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.freelancetask.entity.Circle;
import com.springjpa.freelancetask.entity.District;
import com.springjpa.freelancetask.repository.CircleRepository;

@Service
public class CircleService {

	@Autowired
	private CircleRepository circleRepository;
	
	@Autowired
	private DistrictService districtService;
	
	public District getDistrict(Integer circleId) {
		 District division = districtService.getDistrictByCircleId(circleId);
		 return division;
	}

	public List<Circle> getCircles() {
		return circleRepository.findAll();
	}

	public boolean addCircle(List<Circle> circleList) {
		boolean status = false;
		Circle dist = null;
		if(null != circleList && !circleList.isEmpty()) {
			for (Circle circle : circleList) {
				dist = circleRepository.save(circle);
			}
		}
		
		if (null != dist) {
			status = true;
		}
		return status;
	}

	public List<Circle> getCircleByDistrictName(String districtName) {
		List<Circle> districtList = null;
		if(null != districtName && !"".equals(districtName.trim())) {
			districtList = circleRepository.findByDistrictName(districtName.trim());
		}		
		return districtList;
	}
}

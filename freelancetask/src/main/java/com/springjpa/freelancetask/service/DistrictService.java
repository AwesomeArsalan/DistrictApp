package com.springjpa.freelancetask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjpa.freelancetask.entity.District;
import com.springjpa.freelancetask.repository.DistrictRepository;

@Service
public class DistrictService {

	@Autowired
	private DistrictRepository districtRepository;

	public District getDistrictByCircleId(Integer circleId) {
		Optional<District> district = districtRepository.findById(circleId);
		return district.get();
	}

	public boolean addDistrict(List<District> districtList) {
		boolean status = false;
		District divs = null;
		if(null != districtList && !districtList.isEmpty()) {
			for (District district : districtList) {
				divs = districtRepository.save(district);
			}
		}
		
		if (null != divs) {
			status = true;
		}
		return status;
	}

	public List<District> getDistrict() {
		return districtRepository.findAll();
	}
}

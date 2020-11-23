package com.kidzona.parentsservice.converter;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.entity.Kid;

public class KidConverter {

	static Mapper mapper = new DozerBeanMapper();
	public static KidDto convertToDto(Kid kid) {
		KidDto parentDto = mapper.map(kid, KidDto.class);
		return parentDto;
	}

	public static Kid convertFromDto(KidDto kidDto) {
		Kid kid = mapper.map(kidDto, Kid.class);
		return kid;
	}

}

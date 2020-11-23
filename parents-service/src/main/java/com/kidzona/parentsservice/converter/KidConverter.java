package com.kidzona.parentsservice.converter;

import org.modelmapper.ModelMapper;

import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.entity.Kid;

public class KidConverter {

	static ModelMapper mapper = new ModelMapper();

	public static KidDto convertToDto(Kid kid) {
		KidDto parentDto = mapper.map(kid, KidDto.class);
		return parentDto;
	}

	public static Kid convertFromDto(KidDto kidDto) {
		Kid kid = mapper.map(kidDto, Kid.class);
		return kid;
	}

}

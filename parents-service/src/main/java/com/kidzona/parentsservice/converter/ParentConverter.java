package com.kidzona.parentsservice.converter;

import org.springframework.stereotype.Component;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;


@Component
public class ParentConverter {
	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

	mapperFactory.classMap(Parent.class , ParentDto.class).byDefault();

	

}

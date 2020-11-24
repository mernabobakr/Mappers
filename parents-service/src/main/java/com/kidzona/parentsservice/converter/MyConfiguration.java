package com.kidzona.parentsservice.converter;

import org.hibernate.annotations.Parent;

import com.kidzona.parentsservice.dto.ParentDto;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class MyConfiguration extends ConfigurableMapper {
@Override
protected void configure (MapperFactory factory) {
	factory.classMap(Parent.class, ParentDto.class).register();;
}
}

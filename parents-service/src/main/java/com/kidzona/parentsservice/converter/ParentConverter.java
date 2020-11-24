package com.kidzona.parentsservice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
@Component
public class ParentConverter {
	
	MapperFacade mapper = new MyConfiguration();

	public ParentDto convertToDto(Parent parent) {
		ParentDto parentDto = mapper.map(parent, ParentDto.class);
		return parentDto;
	}

	public Parent convertFromDto(ParentDto parentDto) {
		Parent parent = mapper.map(parentDto, Parent.class);
		return parent;
	}

	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.setEmail("ndjfns");
		parent.setFirstName("ddd");
		parent.setId(3);
		parent.setLastName("ddd");
		ParentConverter conv = new ParentConverter();
		ParentDto d = conv.convertToDto(parent);
		System.out.println(d.getEmail());
		System.out.print("worked correctly");
	}
}

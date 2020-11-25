package com.kidzona.parentsservice.converter;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;



public class ParentConverter {
	
	  public static void main(String[] args) {
		   SimpleSourceDestinationMapper mapper
		     = Mappers.getMapper(SimpleSourceDestinationMapper.class);
		  Parent parent = new Parent();
			parent.setEmail("ndjfns");
			parent.setFirstName("first");
			parent.setId(3);
			parent.setLastName("last");
			ParentDto parentDto = mapper.parentToParentDTO(parent);
			System.out.println(parentDto.getFirstName());
			//ParentConverter conv = new ParentConverter();
			//ParentDto d = conv.convertToDto(parent);
	    }
	 
}

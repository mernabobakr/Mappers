package com.kidzona.parentsservice.converter;

import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;



public class ParentConverter {
	
	  public static void main(String[] args) {
		 
		  Parent parent = new Parent();
			parent.setEmail("ndjfns");
			parent.setFirstName("first");
			parent.setId(3);
			parent.setLastName("last");
			 ParentDto parentDto = ParentMapper.INSTANCE.parentToParentDto( parent );
			
			System.out.println(parentDto.getFullName().getFirst());
			//ParentConverter conv = new ParentConverter();
			//ParentDto d = conv.convertToDto(parent);
	    }
	 
}

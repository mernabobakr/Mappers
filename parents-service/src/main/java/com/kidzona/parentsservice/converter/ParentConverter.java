package com.kidzona.parentsservice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;



@Component

public class ParentConverter {
	@Autowired
	private static ParentMapper parentMapper; 
	  public static void main(String[] args) {
		  Parent parent = new Parent();
			parent.setEmail("ndjfns");
			parent.setFirstName("first");
			parent.setId(3);
			parent.setLastName("last");
			 //ParentDto parentDto = ParentMapper.INSTANCE.parentToParentDto( parent );
			 ParentDto parentDto  =  parentMapper.toParentDto(parent);
			//System.out.println(parentDto.getFullName().getFirst());
			//ParentConverter conv = new ParentConverter();
			//ParentDto d = conv.convertToDto(parent);
	    }
	 
}

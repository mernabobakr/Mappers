package com.kidzona.parentsservice.converter;


import org.modelmapper.ModelMapper;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;

public class ParentConverter {
	static ModelMapper mapper = new ModelMapper();
	public static ParentDto convertToDto(Parent parent) {
		ParentDto parentDto = mapper.map(parent, ParentDto.class);
		return parentDto;
	}

	public static Parent convertFromDto(ParentDto parentDto) {
		Parent parent = mapper.map(parentDto, Parent.class);
		return parent;
	}
	  public static void main(String[] args) {
	        Parent parent=new Parent();
	        parent.setEmail("ndjfns");
	        parent.setFirstName("ddd");
	        parent.setId(3);
	        parent.setLastName("ddd");
	        ParentDto d=convertToDto(parent);
	        System.out.println(d.getEmail());
	        System.out.print("worked correctly");
	    }

}

package com.kidzona.parentsservice.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;
@Mapper(componentModel = "spring")

public interface SimpleSourceDestinationMapper{
	
	      @Mapping(target="firstName", source="parent.lastName")
	      @Mapping(target="employeeName", source="entity.firstName")
	    
	    ParentDto parentToParentDTO(Parent parent);
	   
	      @Mapping(target="lastName", source="firstName.employeeId")
	      @Mapping(target="firstName", source="parentDto.lastName")
	
	    Parent parentDTOtoParent(ParentDto parentDto);
}

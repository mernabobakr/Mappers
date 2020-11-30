package com.kidzona.parentsservice.converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;
@Component
@Mapper(componentModel="spring")
public interface ParentMapper {
	
	
	

	 @Mapping(source = "firstName", target = "fullName.first")
	 @Mapping(source = "lastName", target = "fullName.last")
	 public ParentDto toParentDto (Parent parent);
}

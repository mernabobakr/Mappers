package com.kidzona.parentsservice.converter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.entity.Parent;

@Mapper(componentModel="spring")
public interface ParentMapper {
	
	ParentMapper INSTANCE = Mappers.getMapper( ParentMapper.class );
	 @Mapping(source = "firstName", target = "fullname.first")
	 @Mapping(source = "lastName", target = "fullname.last")
	    ParentDto parentToParentDto(Parent parent);
}

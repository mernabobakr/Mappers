package com.kidzona.parentsservice.converter;

import org.springframework.stereotype.Component;
import com.kidzona.parentsservice.dto.KidDto;
import com.kidzona.parentsservice.dto.ParentDto;
import com.kidzona.parentsservice.dto.SkillDto;
import com.kidzona.parentsservice.entity.Kid;
import com.kidzona.parentsservice.entity.Parent;
import com.kidzona.parentsservice.entity.Skill;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class MyConfiguration implements OrikaMapperFactoryConfigurer {
	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(Kid.class, KidDto.class).field("firstName", "name").field("skills", "skills")
				.byDefault().register();
		orikaMapperFactory.classMap(Parent.class, ParentDto.class).field("firstName", "fullName.first").field("lastName", "fullName.last")
		.field("id", "id").field("address", "address").field("pictureUrl", "pictureUrl").field("email", "email")
		.field("kids{id}", "kids{id}").field("kids{firstName}", "kids{name}")
		.field("kids{schoolAddress}", "kids{schoolAddress}").field("firstName", "fullName.first")
		.exclude("Kids{skills}").mapNulls(false).mapNullsInReverse(false).register();

		orikaMapperFactory.classMap(Skill.class, SkillDto.class).byDefault().register();
	}

}

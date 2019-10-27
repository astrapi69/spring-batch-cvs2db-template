package de.alpharogroup.spring.batch.cvs2db.mapper;

import de.alpharogroup.spring.batch.cvs2db.dto.Friend;
import de.alpharogroup.spring.batch.cvs2db.entity.FriendsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface FriendsEntityMapper  extends GenericMapper<FriendsEntity, Friend> {
	@Mappings({ @Mapping(target = "id", source = "dto.id"), @Mapping(target = "firstname", source = "dto.firstname"),
			@Mapping(target = "lastname", source = "dto.lastname"), @Mapping(target = "city", source = "dto.city") })
	FriendsEntity toEntity(Friend dto);

}
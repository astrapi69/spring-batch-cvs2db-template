package de.alpharogroup.spring.batch.mapper;

import de.alpharogroup.spring.batch.dto.Bro;
import de.alpharogroup.spring.batch.entity.BrosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrosEntityMapper extends GenericMapper<BrosEntity, Bro> {
}

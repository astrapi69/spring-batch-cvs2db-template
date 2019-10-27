package de.alpharogroup.spring.batch.cvs2db.mapper;

import de.alpharogroup.spring.batch.cvs2db.dto.Bro;
import de.alpharogroup.spring.batch.cvs2db.entity.BrosEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrosEntityMapper extends GenericMapper<BrosEntity, Bro> {
}

/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.spring.batch.cvs2db.mapper;

import java.util.Collection;
import java.util.List;

import lombok.NonNull;

/**
 * The Interface {@link GenericMapper} provides the methods for mapping entities to data transfer objects
 * and back.
 *
 * @param <ENTITY>
 *            the element type of the entity object
 * @param <DTO>
 *            the generic type of the data transfer object
 */
public interface GenericMapper<ENTITY, DTO>
{

	/**
	 * Maps the given entity object to a data transfer object
	 *
	 * @param entity
	 *            the entity object
	 * @return the data transfer object
	 */
	DTO toDto(final @NonNull ENTITY entity);

	/**
	 * Maps the given collection of entity objects to a list of data transfer objects
	 *
	 * @param entities
	 *            the collection of entities objects
	 * @return the list of data transfer objects
	 */
	List<DTO> toDtos(final @NonNull Collection<ENTITY> entities);

	/**
	 * Maps the given list of data transfer objects to a list of entity objects
	 *
	 * @param dtos
	 *            the list of data transfer objects
	 * @return the list of entity objects.
	 */
	List<ENTITY> toEntities(final @NonNull Collection<DTO> dtos);

	/**
	 * Maps the given data transfer object to a entity object.
	 *
	 * @param dto
	 *            the data transfer object
	 * @return the entity object
	 */
	ENTITY toEntity(final @NonNull DTO dto);

}
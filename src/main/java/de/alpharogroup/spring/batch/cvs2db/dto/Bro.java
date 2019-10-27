package de.alpharogroup.spring.batch.cvs2db.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * TODO delete after cloning template project
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bro
{
	int id;
	String firstname;
	String lastname;
	String city;
}

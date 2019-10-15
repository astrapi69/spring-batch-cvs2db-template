package de.alpharogroup.spring.batch.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ConfigurationProperties(prefix = "app")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApplicationProperties {

	String name;
	String dbHost;
	String dbName;
	int dbPort;
	String dbUrlPrefix;
	String dbUsername;
	String dbPassword;
	String dir;
	String csvDir;
	String brosFileName;

	String friendsFileName;

}

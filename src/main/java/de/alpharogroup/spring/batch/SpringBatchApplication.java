package de.alpharogroup.spring.batch;

import de.alpharogroup.spring.batch.cvs2db.configuration.ApplicationProperties;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableBatchProcessing
@EnableTransactionManagement
@EnableConfigurationProperties({ ApplicationProperties.class })
@SpringBootApplication
@ComponentScan(basePackages={ "de.alpharogroup.spring.batch.cvs2db.configuration",
	"de.alpharogroup.spring.batch.cvs2db.mapper"})
@EntityScan(basePackages={"de.alpharogroup.spring.batch.cvs2db.entity"})
public class SpringBatchApplication extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}

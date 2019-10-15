package de.alpharogroup.springbatchtemplate;

import de.alpharogroup.spring.batch.configuration.ApplicationProperties;
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
@ComponentScan(basePackages={"de.alpharogroup.spring.batch.configuration",
	"de.alpharogroup.spring.batch.mapper"})
@EntityScan(basePackages={"de.alpharogroup.spring.batch.entity"})
public class SpringBatchTemplateApplication extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchTemplateApplication.class, args);
	}

}

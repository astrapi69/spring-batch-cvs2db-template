package de.alpharogroup.spring.batch.cvs2db.configuration;

import javax.persistence.EntityManagerFactory;

import de.alpharogroup.spring.batch.cvs2db.dto.Bro;
import de.alpharogroup.spring.batch.cvs2db.entity.BrosEntity;
import de.alpharogroup.spring.batch.factory.SpringBatchObjectFactory;
import de.alpharogroup.spring.batch.cvs2db.mapper.BrosEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Configuration
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CsvFileToBrosStepConfiguration {

	EntityManagerFactory entityManagerFactory;

	ApplicationProperties applicationProperties;

	StepBuilderFactory stepBuilderFactory;

	PlatformTransactionManager transactionManager;

	@Bean
	public FileSystemResource brosResource() {
		String filePath = applicationProperties.getCsvDir() + "/" + applicationProperties.getBrosFileName();
		return new FileSystemResource(filePath);
	}

	@Bean
	public FlatFileItemReader<Bro> brosReader() {
		return SpringBatchObjectFactory.newCsvFileItemReader(brosResource(), Bro.class, ";", 1);
	}

	@Bean
	public JpaItemWriter<BrosEntity> brosWriter() {
		return SpringBatchObjectFactory.newJpaItemWriter(entityManagerFactory);
	}

	@Bean
	public ItemProcessor<Bro, BrosEntity> brosProcessor() {
		return new ItemProcessor<Bro, BrosEntity>() {
			@Override
			public BrosEntity process(Bro item) throws Exception {
				BrosEntity entity = Mappers.getMapper(BrosEntityMapper.class).toEntity(item);
				return entity;
			}
		};
	}

	@Bean
	public Step csvFileToBrosStep() {
		return stepBuilderFactory.get("csvFileToBrosStep").<Bro, BrosEntity>chunk(10).reader(brosReader())
				.processor(brosProcessor()).writer(brosWriter()).transactionManager(transactionManager).build();
	}

}
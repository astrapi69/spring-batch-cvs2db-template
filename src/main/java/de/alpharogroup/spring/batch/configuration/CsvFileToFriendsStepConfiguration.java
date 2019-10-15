package de.alpharogroup.spring.batch.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import de.alpharogroup.spring.batch.dto.Friend;
import de.alpharogroup.spring.batch.entity.FriendsEntity;
import de.alpharogroup.spring.batch.factory.SpringBatchObjectFactory;
import de.alpharogroup.spring.batch.mapper.FriendsEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
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
public class CsvFileToFriendsStepConfiguration {

	EntityManagerFactory entityManagerFactory;

	ApplicationProperties applicationProperties;

	StepBuilderFactory stepBuilderFactory;

	PlatformTransactionManager transactionManager;

	@Bean
	public FileSystemResource friendsResource() {
		String filePath = applicationProperties.getCsvDir() + "/" + applicationProperties.getFriendsFileName();
		return new FileSystemResource(filePath);
	}

	@Bean
	public FlatFileItemReader<Friend> friendsReader() {
		return SpringBatchObjectFactory
			.newCsvFileItemReader(friendsResource(), Friend.class, ";", 1);
	}

	@Bean
	public JpaItemWriter<FriendsEntity> friendsWriter() {
		return SpringBatchObjectFactory.newJpaItemWriter(entityManagerFactory);
	}

	@Bean
	public ItemProcessor<Friend, FriendsEntity> friendsProcessor() {
		return new ItemProcessor<Friend, FriendsEntity>() {
			@Override
			public FriendsEntity process(Friend item) throws Exception {
				FriendsEntity entity = Mappers.getMapper(FriendsEntityMapper.class).toEntity(item);
				return entity;
			}

		};
	}

	@Bean
	public Step csvFileToFriendsStep() {
		return stepBuilderFactory.get("csvFileToFriendsStep").<Friend, FriendsEntity>chunk(10)
				.reader(friendsReader()).processor(friendsProcessor()).writer(friendsWriter()).faultTolerant()
				.skip(FlatFileParseException.class).skip(PersistenceException.class).skipLimit(10)
				.allowStartIfComplete(true).transactionManager(transactionManager).build();
	}

}
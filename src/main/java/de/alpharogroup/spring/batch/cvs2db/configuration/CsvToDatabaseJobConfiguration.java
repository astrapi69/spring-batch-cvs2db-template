package de.alpharogroup.spring.batch.cvs2db.configuration;

import lombok.NonNull;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvToDatabaseJobConfiguration {

	@Bean
	public Job importCsvFilesJob(@NonNull JobBuilderFactory jobBuilderFactory,
			CsvToDatabaseJobExecutionListener csvToDatabaseJobExecutionListener,
		Step csvFileToBrosStep,
			Step csvFileToFriendsStep) {
		return jobBuilderFactory.get("importCsvFilesJob").incrementer(new RunIdIncrementer())
				.listener(csvToDatabaseJobExecutionListener).start(csvFileToBrosStep).next(csvFileToFriendsStep)
				.build();
	}
}

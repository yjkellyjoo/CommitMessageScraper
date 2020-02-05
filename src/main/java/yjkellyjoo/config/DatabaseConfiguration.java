package yjkellyjoo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
public class DatabaseConfiguration {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasources.nvd") 
	public DataSource dataSourceNvd() {
		return DataSourceBuilder.create().build();
	}
	  
	@Bean
	@ConfigurationProperties(prefix = "spring.datasources.git")
	public DataSource dataSourceGit() {
		return DataSourceBuilder.create().build();
	 }
}

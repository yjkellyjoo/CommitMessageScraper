package yjkellyjoo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class DatabaseConfiguration {
	public static final String NVD_DATASOURCE = "NvdDS";
	public static final String GIT_DATASOURCE = "GitDS";

	@Bean(name = NVD_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "datasources.nvd")
	@Primary
	public DataSource dataSourceNvd() {
		// Filled up with the properties specified about thanks to Spring Boot black magic
		return new HikariDataSource();
	}
	  
	@Bean(name = GIT_DATASOURCE, destroyMethod = "")
	@ConfigurationProperties(prefix = "datasource.git")
	public DataSource dataSourceGit() {
		// Filled up with the properties specified about thanks to Spring Boot black magic
		return new HikariDataSource();
	 }
}

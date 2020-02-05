package yjkellyjoo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import yjkellyjoo.nvd.service.NvdCommitService;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class CommitMessageScraperApplication implements CommandLineRunner {

	@Resource(name="yjkellyjoo.nvd.service.NvdCommitService")
	private NvdCommitService nvdCommitService;

	public static void main(String[] args) {
		SpringApplication.run(CommitMessageScraperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		nvdCommitService.perform();
	}
}

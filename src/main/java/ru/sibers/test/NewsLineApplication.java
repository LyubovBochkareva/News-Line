package ru.sibers.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.sibers.test.newsline.config.AppInitializer;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@SpringBootApplication
public class NewsLineApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsLineApplication.class, args);
	}

	@Bean
	public String init(AppInitializer appInitializer) {
		appInitializer.init();
		return "initOk";
	}
}
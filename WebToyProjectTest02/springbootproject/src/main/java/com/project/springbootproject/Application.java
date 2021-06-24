package com.project.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//devtools property settings (커스텀 세팅)
		//System.setProperty("spring.devtools.restart.enabled", "false");
		//System.setProperty("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter () {
		HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
		return filter;
	}

}

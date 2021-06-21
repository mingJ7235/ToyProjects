package com.project.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		//devtools property settings (커스텀 세팅)
		//System.setProperty("spring.devtools.restart.enabled", "false");
		//System.setProperty("spring.devtools.livereload.enabled", "true");
		SpringApplication.run(BoardApplication.class, args);
	}

}

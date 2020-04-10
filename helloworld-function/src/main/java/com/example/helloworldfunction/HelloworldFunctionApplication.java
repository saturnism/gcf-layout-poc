package com.example.helloworldfunction;

import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloworldFunctionApplication {
  @Bean
	Function<String, String> hello() {
  	return (name) -> "Hello " + name;
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloworldFunctionApplication.class, args);
	}

}


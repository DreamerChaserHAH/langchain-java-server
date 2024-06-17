package com.htetaung.langchain_java_server.langchain_java_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LangchainJavaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LangchainJavaServerApplication.class, args);
	}

}

@RestController
class HelloController{
	@GetMapping("/")
	static String index(){
		return "Hello World";
	}
}

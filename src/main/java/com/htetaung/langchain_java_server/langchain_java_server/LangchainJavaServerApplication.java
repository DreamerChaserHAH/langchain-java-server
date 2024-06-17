package com.htetaung.langchain_java_server.langchain_java_server;

import dev.langchain4j.model.anthropic.AnthropicChatModel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LangchainJavaServerApplication {

	@Value("${CLAUDE_API}")
	private String claudeApiKey;

	public static void main(String[] args) {
		SpringApplication.run(LangchainJavaServerApplication.class, args);
	}

	@PostConstruct
	public void init() {
		DataContainer.model = AnthropicChatModel.withApiKey(claudeApiKey);
	}
}

class DataContainer{
	public static AnthropicChatModel model;
}

@RestController
class HelloController{

	@GetMapping("/")
	public String index(){
		String answer = DataContainer.model.generate("My name is Ethan. Say Hello {my name}'");
		return answer;
	}
}

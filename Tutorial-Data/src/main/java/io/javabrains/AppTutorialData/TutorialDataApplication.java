package io.javabrains.AppTutorialData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.javabrains.hello") // use this if the webpage isn't showing
@ComponentScan("io.javabrains.topic") 

@SpringBootApplication
public class TutorialDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialDataApplication.class, args);
	}

}

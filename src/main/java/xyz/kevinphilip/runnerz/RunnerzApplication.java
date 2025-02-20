package xyz.kevinphilip.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import xyz.kevinphilip.runnerz.run.Location;
import xyz.kevinphilip.runnerz.run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);


		// Here we are controlling the instance of the class using "new".
		// We probably shouldn't do this because Spring can handle instances for us automatically
		//		var welcomeMessage = new WelcomeMessage();
		//		System.out.println(welcomeMessage.getWelcomeMessage());

		// There is something called the ContextContainer which holds classes
		// Each instance of a class is then referenced to as a "bean"
		// Ensure that the class is in the main package or else it won't be found
		//		WelcomeMessage welcomeMessage = context.getBean(WelcomeMessage.class);
		//		System.out.println(welcomeMessage.getWelcomeMessage());

		// Logging
		// There are different levels of logging, see documentation
		//		log.info("Application started successfully");

		// What is Devtools
		// When you save, it should automatically reload the application, but you have to enable it


		// Architectures
		// He explained that a popular structure is MVC where you have a model and controller package within the main package
		// The problem is with that you have to import everything and it's a bit of a mess
		// Another approach is the Feature pattern e.g. run and user



	}


	// A command line runner is a way to run code when the application starts
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 10, Location.OUTDOOR);
		};
	}

}

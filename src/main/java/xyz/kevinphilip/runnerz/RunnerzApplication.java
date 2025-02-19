package xyz.kevinphilip.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
		log.info("Application started successfully");

	}

}

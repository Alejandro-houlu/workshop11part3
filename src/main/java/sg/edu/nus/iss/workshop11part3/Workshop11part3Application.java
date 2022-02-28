package sg.edu.nus.iss.workshop11part3;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootApplication
public class Workshop11part3Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop11part3Application.class);

	public static void main(String[] args) {
		logger.info("Workshop 11");
		logger.debug("Workshop 11 - D");
		String portNumber = null;
		SpringApplication app = new SpringApplication(Workshop11part3Application.class);
		//SpringApplication.run(Workshop11part3Application.class, args);

		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List optVals = appArgs.getOptionValues("port");
		logger.info("optVals > " + optVals);
		if(optVals == null || optVals.get(0) == null){
			portNumber = System.getProperty("PORT", "3000");
			//System.getenv("PORT");
			if(portNumber == null){
				portNumber = "3000";
			}
		}else{
			portNumber = (String)optVals.get(0);
		}

		if(portNumber != null){
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber)); 
		}

		app.run(args);
	}

}

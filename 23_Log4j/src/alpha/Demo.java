package alpha;

import org.apache.logging.log4j.*;


public class Demo {

	private static Logger log = LogManager.getLogger(Demo.class.getName());
	
	public static void main(String[] args) {
		
		log.debug("I have clicked on button");
		log.error("Button is not displayed");
		log.info("Button is displayed");
		log.fatal("Button is missing");
	}
}
import org.apache.log4j.Logger;

public class TestLog4J {

	
	static Logger log = Logger.getLogger(TestLog4J.class);
	
	public static void main(String[] args) {


		log.debug("This is a Debug Log");
		log.info("This is a Info Log");
		log.error("Error in a Project");
	}

}

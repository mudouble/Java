//import com.sun.javaws.Main;
//import org.slf4j.Logger;
import sun.security.tools.keytool.Main;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;


public class logging {
    public static void main(String[] args) {
//        Logger logger = Logger.getGlobal();
//        logger.info("start process...");
//        logger.warning("memory is running out...");
//        logger.fine("ignore");
//        logger.severe("process will be terminated");
        Logger logger1 = Logger.getLogger(Main.class.getName());
        logger1.info("start process...");
        try{
            "".getBytes("invalidCharseName");

        } catch (UnsupportedEncodingException e) {
            logger1.severe(e.toString());
//            throw new RuntimeException(e);
        }
        logger1.info("Process end.");
    }

}


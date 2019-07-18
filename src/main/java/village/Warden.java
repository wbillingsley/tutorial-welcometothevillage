package village;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Wardens are a special kind of villager whose job is to keep an eye on the villagers.
 * (They are all retired spies carrying a lifetime of state secrets, you know...)
 */
public class Warden extends Villager {
    
    // Loggers are like a souped up println...
    private static final Logger logger = LogManager.getLogger(Warden.class);

    private Random rng = new Random();

    @Override
    public boolean isWarden(Villager v) {

        int seconds = Calendar.getInstance().get(Calendar.SECOND);
        if (seconds % 2 == 0) {
            logger.debug("I'm going to tell the truth");
            return (v instanceof Warden);
        } else {
            logger.debug("I'm going to lie");
            return !(v instanceof Warden);
        }
    } 

}
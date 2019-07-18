package village;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Village.
 *
 * An `enum` is like a class, except that you declare the instances of the class up-front. For example, we
 * could declare an enum for the days of the week (Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday)
 * because those are the only days and programs won't need to instantiate any other days than those.
 */
public enum Village {
    
    // There is only one village
    INSTANCE;

    // Loggers are like a souped up println...
    private static final Logger logger = LogManager.getLogger(Village.class);

    // Rover is the Village's very unusual guard robot.
    Rover rover = new Rover();

    List<Villager> inhabitants = new ArrayList<>();

    /**
     * When a Villager yells and makes a mad dash along the beach, send rover to have them collected
     */
    public void declareEscape(Villager escapee, String yell) {
        rover.collect(escapee);
    }

    public void enter(Villager v) {
        logger.debug("{} has entered the village", v.getName());
        inhabitants.add(v);
    }

    public void clear() {
        logger.debug("Clearing the village for the start of a new test");
        inhabitants.clear();
    }

}
package village;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Rover is the world's most unusual robot guard.
 *
 * It looks like a weather balloon and is blown along by automated wind
 * generators placed around the Village. Its job, if a Villager tries 
 * to escape, is to chase after them, knock them over, and bounce on
 * top of them until they can be collected and taken to the hospital.
 *
 * (There are very rarely any injuries in the Village, so the hospital
 * spends most of its time conducting psychological experiments to try
 * to train Villagers not to think about escaping.)
 */
public class Rover {

    // Loggers are like a souped up println...
    private static final Logger logger = LogManager.getLogger(Rover.class);

    static int escapeesCollected = 0;

    public static int getEscapeesCollected() { 
        return Rover.escapeesCollected;
    }

    /**
     * When asked, Rover will go and collect an escaping visitor
     */
    public void collect(Villager escapee) {
        logger.info("Bounce, bounce, bounce. Rover has collected {}", escapee.getName());
        Rover.escapeesCollected++;
        logger.info("Sending {} to the hospital for psychological conditioning", escapee.getName());
        escapee.condition();

        // To make the villager's escape attempt fail, we throw a RuntimeException (pun intended!)
        throw new RuntimeException("Rover thwarted the escape attempt and took the villager to the hospital for conditioning");
    }

}
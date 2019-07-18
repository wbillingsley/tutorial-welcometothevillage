package village;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Villagers live in the Village.
 * 
 * They are mostly retired secret service staff from around the world, retired 
 * to the Village as a safe and comfortable place to live out their days. They
 * are friendly with each other, regardless of which country they came from or
 * used to work for, and if you ask them about their life before the village
 * they will simply tell you that unfortunately they don't remember.
 */
public class Villager {

    // Loggers are like a souped up println...
    private static final Logger logger = LogManager.getLogger(Villager.class);

	/**
	 * The next number to allocate to a villager.
	 */
	private static int nextNumber = 7;

    /**
     * Whether this Villager has undergone psychological conditioning to prevent them from trying to escape
     */
    private boolean conditioned = false;
	
	/**
	 * Your number is your name
	 */
	protected int number;
		
	/**
	 * Gives this villager a number as they enter the village
	 */
	protected void allocateNumber() {
		this.number = nextNumber;
		nextNumber++;
	}

    public Villager() {
        allocateNumber();
        Village.INSTANCE.enter(this);
    }


    /**
     * If you ask a Villager their name, they will tell you their number instead
     */
    public String getName() {
        return "Number " + number;
    }

    /**
     * If you ask a Villager where they are from, they simply don't remember
     */
    public String getOrigin() { 
        throw new UnsupportedOperationException("I'm so sorry, I just don't remember. I do have such a forgetful memory.");
    }

    /**
     * If you ask a Villager if they are a Warden, they will tell you the truth
     */
    public boolean isWarden() { 
        return false;
    }

    /**
     * If you ask a Villager if they think someone else is a Warden, they will say no - they don't know about Wardens
     */
     public boolean isWarden(Villager v) {
         logger.debug("I've been asked if {} is a warden.", v.getName());
         return false;
     }

     /**
      * If you persuade them to try to escape, Villagers yell "I'm getting out of here!" and make a mad dash along the
      * beach to try to make it past the headland.
      */
     public boolean escape() {
         logger.debug("I was asked to escape.");

         if (conditioned) {
             logger.debug("But I've been conditioned not to.");
             throw new UnsupportedOperationException("No, I couldn't possibly think of doing that");
         } else {
             logger.debug("I'm going to run madly along the beack and try to get past the headland.");
             Village.INSTANCE.declareEscape(this, "I'm getting out of here!");

             // Hmm, we'll discover if this succeeds.
             logger.debug("Hooray! I've escaped the Village!");
             return true;
         }
     }

     /**
      * When the hospital conditions a villager, they will remember not to try to escape.
      */
     public void condition() {
         logger.info("I ... must ... not ... try ... to ... escape ...");
         this.conditioned = true;
     }


}
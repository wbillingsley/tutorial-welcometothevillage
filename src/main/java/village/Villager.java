package village;

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
         return false;
     }

     /**
      * If you persuade them to try to escape, Villagers yell "I'm getting out of here!" and make a mad dash along the
      * beach to try to make it past the headland.
      */
     public boolean escape() {
         if (conditioned) {
             throw new UnsupportedOperationException("No, I couldn't possibly think of doing that");
         } else {
             Village.INSTANCE.declareEscape(this, "I'm getting out of here!");
         }
     }


}
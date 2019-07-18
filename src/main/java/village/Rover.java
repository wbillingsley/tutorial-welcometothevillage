package village;

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

    static int escapeesCollected = 0;

    public static int getEscapeesCollected() { 
        return Rover.escapeesCollected;
    }

    public void collect(Villager escapee) {
        Rover.escapeesCollected++;


    }

}
package village;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Today's tutorial (and spy story) is written in the tests...
 * Test classes have "Test" somewhere in their name, so that JUnit knows which classes might contain tests.
 *
 *
 * Welcome to The Village...
 *
 * This tutorial is loosely inspired by a 1960s tv show (yes, before I was born too) called The Prisoner, in which
 * a spy is kidnapped and put into a strange seaside village that is also an unusual prison. Nobody knows who is a
 * guard and who is a prisoner, and nobody can leave. Everyone is known by their number instead of their name. And the
 * prison uses all sorts of (progressively stranger) psychological trickery to get its prisoners to comply and to get
 * whatever information it wanted from them.
 *
 */
class TutorialTest {

    /*
     * Because Test classes are classes, they can have fields, and can have static fields.
     * This field is a logger. Loggers are like a more advanced println, for writing messages out to the console or a log file.
     */
    private static final Logger logger = LogManager.getLogger(TutorialTest.class);


    /*
     * We can have functions that are run before any of the tests in this class are run.
     * These functions are annotated @BeforeAll and have to be static methods 
     */
    @BeforeAll
    public static void beforeAll() {
        logger.info("This message was printed out before any of the tests were run");
    }

    /*
     * We can also have functions that are run before each individual test is run.
     * These methods are annotated @BeforeEach and must not be static
     *
     * In this case, we clear the village, so that in each of our tests we can put in just the villagers we want to be there
     * (rather than also having the villagers from any previous tests that have been run).
     */
    @BeforeEach
    public void beforeEach() {
        logger.info("This message gets printed before each test runs");
        Village.INSTANCE.clear();
    }

    /*
     * Tests are functions that have an @Test annotation before them.
     * The typical format of a test is that it contains some code that does something, and then one
     * or more assertions to check that a condition holds. For example, the test below verifies that ordinary Villagers
     * do not think they are Wardens.
     */
    @Test
    public void testVillagersDontThinkTheyAreWardens() {
        logger.info("Testing villagers claim not to be wardens");

        Villager v = new Villager();
        assertEquals(false, v.isWarden());
    }

    /*
     TASK - 

     Run the tests (using "gradle test"). 
     Using a web browser, open the test results that are produced in build/reports/tests/test/index.html
     (Ctrl-O will open a file browser in most browsers, to let you navigate to it. Or, if there are failing tests
     then gradle will write out the URL to the test report for you to open.)

     Explore the test results to see which ones passed and which ones failed. Click on "standard output"
     and/or "standard error" to see what was logged during the test.
     */

    /** 
     * Now it's your turn to write a test.
     * Test that wardens, if you ask them, also claim they DON'T think they are wardens...
     */
    @Test
    public void testWardensClaimNotToBeWardens() {
        logger.error("This test has not been implemented yet");

        // write your test code here, replacing this obviously wrong code...
        fail("This test hasn't been written yet");
    }

    /**
     * We can group assertions together. Here, we're asserting that if we have two villagers, and we ask
     * each of them if they think the other one is a warden, they will claim they don't think they are.
     */
    @Test
    public void testVillagersThinkEachOtherVillagers() {
        logger.info("Testing villagers think each other are villagers");

        Villager v1 = new Villager();
        Villager v2 = new Villager();
        assertAll(
            "Villagers don't suspect each other of being wardens",
            () -> assertFalse(v1.isWarden(v2)),
            () -> assertFalse(v2.isWarden(v1))
        );
    }

    /**
     * Your turn - create two villagers and a warden. Test that both villagers think the warden is just
     * another villager
     */
    @Test
    public void testVillagersThinkWardensAreVillagers() {
        logger.info("Testing villagers think wardens are villagers");

        // write your test code here, replacing this obviously wrong code...
        fail("This test hasn't been written yet");        
    }

    /**
     * Rover is the Village's automated guard. Whenever a Villager tries to escape, Rover is sent to stop them.
     * This test checks that escape attempts fail. In JUnit terms, we're testing that the code below should produce
     * an exception. (With the dreadful pun that escape attempts result in a run-time exception!)
     */
    @Test
    public void testVillagerEscapeFails() {
        logger.info("Testing that attempts to escape fail");

        Villager v1 = new Villager();

        // This asserts that the code below must throw a RuntimeException.
        // () -> v1.escape() is a "lambda function". It is a Java 8 feature that lets us define an object with a single method in it.
        //
        // I've also added a message into the assertion. This is the message that will be given if the test fails.
        assertThrows(RuntimeException.class, () -> v1.escape(), "The Villager got away");
    }

    /**
     * Sometimes we have something we want to assume to be true, or otherwise we should abort the test.
     * Here, we're going to test that when Rover stops an escape, it also incremements the count of how many escapes
     * it has stopped. To do this, we need to try an escape. But this test isn't checking the escape attempt failed - 
     * that was tested in testVillagerEscapeFails(). So instead, we are going to _assume_ that the escape should fail.
     * In practice, this means that if the escape fails, the test will continue; but if the escape doesn't fail, the
     * test will be aborted (there's no point checking Rover's incremented its count if the villager got away)
     */
    @Test
    public void testRoverIncrementsCount() {
        logger.info("Testing that Rover increments the number of villagers collected when it thwarts an escape attempt");

        Villager v1 = new Villager();
        int count = Rover.getEscapeesCollected();

        // unfortunately, there's no "assumeThrows", so we're going to have to do this by catching the exception
        assumeTrue(() -> {
            try {
                v1.escape();
                return false; // escaped
            } catch (RuntimeException ex) {
                return true; // caught      -- TASK. To see what happens when a test is aborted, change this to false and run the tests.
                             //                      (Then change it back again.)
            }
        }, "Rover didn't thwart the escape");

        // Now this assertion will only be made if the previous assumption (that Rover thwarts the escape) is correct
        assertEquals(count + 1, Rover.getEscapeesCollected(), "Rover didn't increment its count");
    }

    /**
     * Your turn. Once a Villager has attempted to escape, they are taken to the hospital to make sure they don't do it
     * again. This means that if they are asked to escape a second time, the villager should throw an
     * UnsupportedOperationException.
     */
    @Test void testVillagerRefusesSecondEscape() {
        // Let's create a new villager
        Villager v1 = new Villager();

        // Let's assume the first time they are asked to escape, they fail.
        assumeTrue(() -> {
            try {
                v1.escape();
                return false; // escaped
            } catch (RuntimeException ex) {
                return true; // caught      -- TASK. To see what happens when a test is aborted, change this to false and run the tests.
                             //                      (Then change it back again.)
            }
        }, "Rover didn't thwart the escape");

        // Now you should test that the second time they are asked to escape, they throw an UnsupportedOperationException.
        // hint: use assertThrows.
        fail("This test has not been implemented yet");
    } 

    /**
     * When the village was first created, its creators didn't know what the villagers would be like. Would they be naturally suspicious
     * and suspect each other of being wardens? Or would they be trusting and not think anybody is a warden? Or somewhere in between?
     * 
     * So, when they first created the village, if a Warden was asked if someone else was a villager, they were told to decide randomly
     * whether they are going to lie or not. (They'd glance at their watch and see if the second was odd or not.)
     *
     * For our testing, this poses a problem. If we just test that wardens tell the truth, half the time it'll succeed and half the time it'll fail
     * depending on whether it's an odd or an even second. Because we want our tests to run automatically, on a server, we want them to be reliable, 
     * not only to work half the time. So, we've disabled this test using the @Disabled annotation.
     *
     * TASK - re-enable this test, run the tests a few times, and see how it means that sometimes you'll get a test failure and sometimes not.
     */
     @Disabled("We don't want unreliable tests")
     @Test
     public void testIfAWardenLies() {
         Warden w1 = new Warden();
         Villager v1 = new Villager();

         assertTrue(w1.isWarden(v1));
     }

     /*
      * Something to think about - 
      * 
      * You might wonder how we'd write a test for the warden's behaviour. Would we write a test that waits until the second is even and then 
      * tests the warden's reaction? Would we write tests that take longer than a second and make sure that over 2 seconds, some wardens lie
      * and others don't?
      *
      * What software engineers would usually do, however, is alter the Warden code to make it more testable. The reason we are having trouble 
      * testing the warden's behaviour is because the Warden class looks at the time. If instead we changed the class so that there was a way
      * for the tests to tell the warden what the time is, then we could test its behavour more easily.
      */

}

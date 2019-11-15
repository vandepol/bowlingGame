package bowlingapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        
       
    }

    @Test
    public void testPerfectGame() {
        Game game = new Game();
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        //bonus
        game.roll(10);
        game.roll(10);

        System.out.println("PerfectGameScore: " + game.score());
        assert(game.score() == 300);

    }

    @Test
    public void testGutterGame() {
        Game game = new Game();
        //frame1
        game.roll(1);
        game.roll(1);
        //frame2
        game.roll(1);
        game.roll(1);
        //frame3
        game.roll(1);
        game.roll(1);
        //frame4
        game.roll(1);
        game.roll(1);
        //frame5
        game.roll(1);
        game.roll(1);
        //frame6
        game.roll(1);
        game.roll(1);
        //frame7
        game.roll(1);
        game.roll(1);
        //frame8
        game.roll(1);
        game.roll(1);
        //frame9
        game.roll(1);
        game.roll(1);
        //frame10
        game.roll(1);
        game.roll(1);

        assert(game.score() == 20);

        System.out.println("Poor: " + game.score());
        assert(game.score() == 20);

    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        AppTest apptest = new AppTest();
        apptest.testPerfectGame();

        apptest.testGutterGame();
    }
}

package bowlingapp;


/**
 * Hello world!
 */
public class Game {

    private Frame[] frames = new Frame[12];
    private int currentFrame = 0;
    private int currentRoll =1;
    private int roll1 = 0;
    private int roll2 = 0;
    public Game() {
    }

    public void roll(int pins){
        if (pins > 10){
            System.err.println("pins value invalid");
            return;
        }
        if (currentFrame >= 12){
            System.err.println("GameOver");
            return;
        }

        //ROLL 1
        if (currentRoll == 1){
            roll1 = pins;
            if (currentFrame > 0){
                //Corner case, 10th frame is strike, bonus 1 is strike and bonus 2 is strike
                if (currentFrame == 11 && frames[9].isStrike() && frames[10].isStrike()){
                    frames[9].addBonus(roll1);
                }
                
                //CASE previous throw was a strike
                if (currentFrame-1 <= 9 && frames[currentFrame-1].isStrike()){
                    if (currentFrame-2 >= 0 && frames[currentFrame-2].isStrike()){
                        frames[currentFrame-2].addBonus(roll1);
                    }
                    frames[currentFrame-1].addBonus(roll1);
                } else if (frames[currentFrame-1].isSpare()){
                    frames[currentFrame-1].addBonus(roll1);
                }
            }
            
            if (roll1 == 10){
                //This avoids adding frames after 10th frame
                //if (currentFrame <= 9) {
                    Frame frame = new Frame(10,0);
                    this.frames[currentFrame] = frame;
                //}
                resetFrame();
                currentFrame++;
                return; 
            } else {
                currentRoll = 2;
            }
        } 
        //ROLL 2
        else { 
            roll2 = pins;
            //GIVE BONUS
            if (currentFrame > 0){
                if (frames[currentFrame-1].isStrike()){
                    frames[currentFrame-1].addBonus(roll2);
                } 
            }

            if (roll1 + roll2 > 10 ){
                System.err.println("pins value invalid roll1: " + roll1 + " roll2: " + roll2);
                return;
            }

            //if (currentFrame <= 9) {
                Frame frame = new Frame(roll1,roll2);
                this.frames[currentFrame] = frame;
            //}
            resetFrame();
            
            currentFrame++;

            currentRoll = 1;
        }
        
    }
    public int score(){
        int totalScore = 0;
        for (int i = 0; i < 10; i++){
            totalScore += frames[i].getScore();
            System.out.println("Frame [" + i + "] score = " + frames[i].getScore());
        }
        return totalScore;
    }

    private void resetFrame(){
        currentRoll =1;
        roll1 = 0;
        roll2 = 0;
    }



    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Game game = new Game();
    }


}

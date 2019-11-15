package bowlingapp;

/**
 * Hello world!
 */
public class Frame {
    private int roll1 = 0;
    private int roll2 = 0;
    private int bonus = 0;
    

    public Frame(int roll1, int roll2) {
        this.roll1 = roll1;
        this.roll2 = roll2;
    }

    public boolean isStrike(){
        if (roll1 == 10){
            return true;
        }
        return false;
    }
    public boolean isSpare(){
        if (roll1 + roll2 == 10){
            return true;
        }
        return false;
    }
    public void addBonus(int bonus){
        this.bonus += bonus;
    }

    public int getScore(){
        return roll1 + roll2 + bonus;
    }

}

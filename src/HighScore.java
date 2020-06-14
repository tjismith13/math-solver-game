public class HighScore  {

    private int highScore = 0;

    //to be called if score is the new high score
    public void updateHighScore(int score) {
        if (score > highScore) highScore = score;
    }
    public int getHighScore() {
        return highScore;
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighScore  {

    //check if passed score is the high score
    public boolean isHighScore(int score) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("src/HighScoreStorage.txt"));
        int currentHighScore = Integer.parseInt(scanner.nextLine());
        scanner.close();
        return score > currentHighScore;
    }

    //to be called if score is the new high score
    public void updateHighScore(int score) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/HighScoreStorage.txt"));
        String currentHighScore = scanner.nextLine();
        scanner.nextLine().replaceAll(currentHighScore, String.valueOf(score));
    }
}

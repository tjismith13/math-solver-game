import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HighScore  {
    public boolean isHighScore(int score) throws FileNotFoundException  {
        Scanner scanner = new Scanner(new File("HighScoreStorage.txt"));
        int currentHighScore = Integer.parseInt(scanner.nextLine());
        return score > currentHighScore;
    }

}

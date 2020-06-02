import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionGenerator {
    private Random random = new Random();


    public String generateQuestion(boolean easy, boolean medium, boolean hard) {

        int signGenerator = random.nextInt(4);
        String sign = " ";
        if (signGenerator == 0) {
            sign = "+";
        }
        else if (signGenerator == 1) {
            sign = "*";
        }
        else if (signGenerator == 2) {
            sign = "-";
        }
        else if (signGenerator == 3) {
            sign = "/";
        }

        if (easy) {
            int firstNum = random.nextInt(10);
            int secondNum = random.nextInt(10);

            return firstNum + sign + secondNum;
        }
        else if (medium) {
            int firstNum = random.nextInt(13);
            int secondNum = random.nextInt(10);

            return firstNum + sign + secondNum;
        }
        else {
            int firstNum = random.nextInt(13);
            int secondNum = random.nextInt(13);

            return firstNum + sign + secondNum;
        }
    }
    public boolean checkCorrect (String question, int answer) {
        char[] chars = question.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for(char c : chars) {
            characterList.add(c);
        }
        if (chars.length == 5) {
            String char1 = String.valueOf(chars[0]);
            String char2 = String.valueOf(chars[1]);
            int firstNum = Integer.parseInt(char1 + char2);
            String char3 = String.valueOf(chars[3]);
            String char4 = String.valueOf(chars[4]);
            int secondNum = Integer.parseInt(char3 + char4);
            if(chars[2] == '*') {
                return firstNum * secondNum == answer;
            }
            else if(chars[2] == '+') {
                return firstNum + secondNum == answer;
            }
            else if(chars[2] == '-') {
                return firstNum - secondNum == answer;
            }
            else {
                return firstNum / secondNum == answer;
            }
        }
        else if (chars.length == 3) {
            int firstNum = Integer.parseInt(String.valueOf(chars[0]));
            int secondNum = Integer.parseInt(String.valueOf(chars[2]));
            if(chars[1] == '*') {
                return firstNum * secondNum == answer;
            }
            else if(chars[1] == '+') {
                return firstNum + secondNum == answer;
            }
            else if(chars[1] == '-') {
                return firstNum - secondNum == answer;
            }
            else {
                return firstNum / secondNum == answer;
            }
        }
    }
}

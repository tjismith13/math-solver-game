import java.util.Random;

public class QuestionGenerator {
    Random random = new Random();


    public String generateQuestion(boolean easy, boolean medium, boolean hard) {
        if (easy) {
            int firstNum = random.nextInt(10);
            int secondNum = random.nextInt(10);

            int signGenerator = random.nextInt(4);
            String sign = " ";
            if (signGenerator == 0) {
                sign = "+";
            }
            if (signGenerator == 1) {
                sign = "*";
            }
            if (signGenerator == 2) {
                sign = "-";
            }
            if (signGenerator == 3) {
                sign = "/";
            }
            return firstNum + sign + secondNum;
        }
        else if (medium) {
            int firstNum = random.nextInt(13);
            int secondNum = random.nextInt(10);

            int signGenerator = random.nextInt(4);
            String sign = " ";
            if (signGenerator == 0) {
                sign = "+";
            }
            if (signGenerator == 1) {
                sign = "*";
            }
            if (signGenerator == 2) {
                sign = "-";
            }
            if (signGenerator == 3) {
                sign = "/";
            }
            return firstNum + sign + secondNum;
        }

    }
}

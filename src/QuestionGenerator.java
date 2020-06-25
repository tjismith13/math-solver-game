import java.util.Random;

public class QuestionGenerator {
    private Random random = new Random();
    private int firstNum;
    private int secondNum;

    //Generates sign, assigning this to sign field.
    //Returns corresponding sign number
    //0: Addition, 1: Multiplication, 2: Subtraction, 3: Division.
    private String generateSign(boolean hard) {
        String sign = "";
        int signGenerator;
        if(!hard) {
            signGenerator = random.nextInt(3);
            if(signGenerator == 0) sign = "+";
            else if (signGenerator == 1) sign = "*";
            else if (signGenerator == 2) sign = "-";
        }

        //Division only an option for hard questions.
        else {
            signGenerator = random.nextInt(4);
            if (signGenerator == 0) sign = "+";
            else if (signGenerator == 1) sign = "*";
            else if (signGenerator == 2) sign = "-";
            else if (signGenerator == 3) sign = "/";
        }
        return sign;
    }

    //When implementing ensure only 1 boolean is true. Leave both false for hard.
    public String generateQuestion(boolean easy, boolean medium) {

        //Easy question generator, numbers lower than 10.
        //No division.
        if (easy) {
            String sign = generateSign(false);
            if (sign.equals("-")) {
                firstNum = random.nextInt(10);
                secondNum = random.nextInt(10);
                while(secondNum > firstNum) {
                    secondNum = random.nextInt(10);
                }
            }
            else {
                firstNum = random.nextInt(10);
                secondNum = random.nextInt(10);
            }

            return firstNum + sign + secondNum;
        }

        //Medium question generator, one number less than 13, one less than 10.
        //No division.
        else if (medium) {
            String sign = generateSign(false);
             if (sign.equals("-")) {
                firstNum = random.nextInt(10);
                secondNum = random.nextInt(10);
                while (secondNum > firstNum) {
                    secondNum = random.nextInt(10);
                }
            }
             else {
                firstNum = random.nextInt(13);
                secondNum = random.nextInt(10);
            }
            return firstNum + sign + secondNum;
        }

        //Hard question generator, both numbers less than 13.
        else {
            String sign = generateSign(true);
            if(sign.equals("/")) {
                secondNum = random.nextInt(13) + 1;
                firstNum = secondNum * random.nextInt(7);
            }
            else if (sign.equals("-")) {
                firstNum = random.nextInt(10);
                secondNum = random.nextInt(10);
                while (secondNum > firstNum) {
                    secondNum = random.nextInt(10);
                }
            }
            else {
                firstNum = random.nextInt(13);
                secondNum = random.nextInt(13);
            }
            return firstNum + sign + secondNum;
        }
    }

    //Check for correct answer. String must be presented in the same form as the generator outputs.
    //No spaces in string.
    public int correctAnswer (String question) {
        char[] chars = question.toCharArray();

        //Check if question has two double digit numbers.
        //If yes assign these numbers to firstNum and secondNum.
        if (chars.length == 5) {
            String char1 = String.valueOf(chars[0]);
            String char2 = String.valueOf(chars[1]);
            firstNum = Integer.parseInt(char1 + char2);
            String char3 = String.valueOf(chars[3]);
            String char4 = String.valueOf(chars[4]);
            secondNum = Integer.parseInt(char3 + char4);

            //Check operator sign and evaluate,
            //return true if the answer passed in is correct.
            if(chars[2] == '*') return firstNum * secondNum;
            else if(chars[2] == '+') return firstNum + secondNum;
            else if(chars[2] == '-') return firstNum - secondNum;
            else return firstNum / secondNum;
        }

        //Check if question has two single digit numbers.
        //Assign these to firstNum and secondNum if yes.
        else if (chars.length == 3) {
            firstNum = Integer.parseInt(String.valueOf(chars[0]));
            secondNum = Integer.parseInt(String.valueOf(chars[2]));

            //Check sign and evaluate, returning
            //true or false based on passed answer.
            if(chars[1] == '*') return firstNum * secondNum;
            else if(chars[1] == '+') return firstNum + secondNum;
            else if(chars[1] == '-') return firstNum - secondNum;
            else return firstNum / secondNum;
        }

        //Question has one single digit and one double digit number.
        else {

            //First number is single digit.
            if(chars[1] == '*' || chars[1] == '+' || chars[1] == '-' || chars[1] == '/') {
                    firstNum = Integer.parseInt(String.valueOf(chars[0]));
                    String char1 = String.valueOf(chars[2]);
                    String char2 = String.valueOf(chars[3]);
                    secondNum = Integer.parseInt(char1 + char2);
            }

            //First number is double digit.
            else {
                String char1 = String.valueOf(chars[0]);
                String char2 = String.valueOf(chars[1]);
                firstNum = Integer.parseInt(char1 + char2);
                secondNum = Integer.parseInt(String.valueOf(chars[3]));
            }

            //Check sign and evaluate, return true or false
            //based on passed answer.
            if(chars[1] == '*' || chars[2] == '*') return firstNum * secondNum;
            else if(chars[1] == '+' || chars[2] == '+') return firstNum + secondNum;
            else if(chars[1] == '-' || chars[2] == '-') return firstNum - secondNum;
            else return firstNum / secondNum;
        }
    }

    //Returns whether answer (taken as input) is equal to the
    //correct answer, which is evaluated using the correctAnswer method.
    public boolean answerIsCorrect(String question, int answer) {
        int correctAnswer = correctAnswer(question);
        return correctAnswer == answer;
    }
}

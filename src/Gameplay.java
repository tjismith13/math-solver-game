import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gameplay {
    private JLabel title;
    private JLabel timeClock;
    private JTextField answerField;
    private JLabel questionField;
    private JLabel highScore;
    private JLabel questionsCorrect;
    private JButton startButton;
    private JLabel actionMessage;
    private JButton answerButton;
    private JPanel background;
    private JLabel actualAnswer;

    private QuestionGenerator generator = new QuestionGenerator();
    private String currentQ;
    private int score = 0;
    private Clock clock = new Clock();
    private String timeRemaining;
    private IntChecker intChecker = new IntChecker();
    private int answer;
    private HighScore highScoreChecker;

    public Gameplay() {

        //When start/restart is pressed
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clock.init(60);
                answerField.setText("");
                score = 0;
                questionsCorrect.setText("Score " + score);
                currentQ = generator.generateQuestion(true, false);
                questionField.setText(currentQ);
                startButton.setText("Restart");
            }
        });

        //When submit is pressed
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startButton.getText().equals("Start")) answerField.setText("Press 'start' to begin!");

                else if (clock.timeRemaining() <= 0) {
                    timeClock.setText("0");
                    answerField.setText("Answer");
                    highScore.setText("High Score" + score);
                    questionField.setText("Question");
                    actualAnswer.setText("");
                   // if(highScoreChecker.isHighScore(score)) {
                        //highScoreChecker.updateHighScore(score);
                    //}
                }

                else {
                    String answerText = answerField.getText();
                    if (!intChecker.isInt(answerText)) answer = -1000;

                    else if(answerText.isEmpty()) answer = -1000;

                    else answer = Integer.parseInt(answerText);

                    if (generator.correct(currentQ) == answer) {
                        score += 1;
                        actualAnswer.setText("Actual Answer:");
                    }

                    else actualAnswer.setText("Actual Answer: " + generator.correct(currentQ));

                    questionsCorrect.setText("Score: " + score);
                    currentQ = generator.generateQuestion(false, true);
                    questionField.setText(currentQ);
                    answerField.setText("");
                    timeRemaining = String.valueOf(clock.timeRemaining());
                    timeClock.setText(timeRemaining);
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmMainScreen");
        Gameplay gameplay = new Gameplay();
        frame.setContentPane(gameplay.background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        File file = new File("/Users/tjismith13/MathSolverGame/src/HighScoreStorage");
        Scanner scanner = new Scanner(file);
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        }
    }

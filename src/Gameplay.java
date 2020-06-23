import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
    private IntChecker intChecker = new IntChecker();
    private int answer;
    private HighScore highScoreChecker = new HighScore();
    private int timesRestart = 0;


    public Gameplay() {

        //When start/restart is pressed
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Thread clockThread = new Thread() {
                    public void run() {
                        clock.init(60);
                        while (clock.timeRemaining() >= 0) {
                            timeClock.setText(String.valueOf(clock.timeRemaining()));
                        }
                        if (clock.timeRemaining() < 1) {
                            //Game reset
                            timeClock.setText("0");
                            answerField.setText("Answer");
                            questionField.setText("Question");
                            actualAnswer.setText("");

                            //Update and display high score
                            highScoreChecker.updateHighScore(score);
                            highScore.setText("High Score: " + highScoreChecker.getHighScore());
                        }
                    }
                };

                clockThread.start();

                //Set or Reset Game
                answerField.setText("");
                score = 0;
                questionsCorrect.setText("Score " + score);

                //Set question generator
                currentQ = generator.generateQuestion(true, false);
                questionField.setText(currentQ);

                startButton.setText("Restart");
            }
        });

        //When submit is pressed
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Ensures game is started
                if (startButton.getText().equals("Start")) answerField.setText("Press 'start' to begin!");

                //While game is happening, first 15 seconds
                else if (clock.timeRemaining() >= 45){

                    //Check that answer is an integer
                    String answerText = answerField.getText();
                    if (!intChecker.isInt(answerText)) answer = -1000;

                    else if (answerText.isEmpty()) answer = -1000;

                    else answer = Integer.parseInt(answerText);

                    //Check answer correctness and update score based on result
                    if (generator.correct(currentQ) == answer) {
                        score += 1;
                        actualAnswer.setText("Actual Answer:");
                    }

                    //If answer is wrong display correct answer
                    else actualAnswer.setText("Actual Answer: " + generator.correct(currentQ));

                    //Questions in easy mode
                    questionsCorrect.setText("Score: " + score);
                    currentQ = generator.generateQuestion(true, false);
                    questionField.setText(currentQ);
                    answerField.setText("");
                }

                //While game is happening, middle 30 seconds
                else if (clock.timeRemaining() >= 15 && clock.timeRemaining() < 45){

                    //Check that answer is an integer
                    String answerText = answerField.getText();
                    if (!intChecker.isInt(answerText)) answer = -1000;

                    else if (answerText.isEmpty()) answer = -1000;

                    else answer = Integer.parseInt(answerText);

                    //Check answer correctness and update score based on result
                    if (generator.correct(currentQ) == answer) {
                        score += 1;
                        actualAnswer.setText("Actual Answer:");
                    }

                    //If answer is wrong display correct answer
                    else actualAnswer.setText("Actual Answer: " + generator.correct(currentQ));

                    //Questions in medium difficulty mode
                    questionsCorrect.setText("Score: " + score);
                    currentQ = generator.generateQuestion(false, true);
                    questionField.setText(currentQ);
                    answerField.setText("");
                }
                //While game is happening, last 15 seconds
                else {

                    //Check that answer is an integer
                    String answerText = answerField.getText();
                    if (!intChecker.isInt(answerText)) answer = -1000;

                    else if (answerText.isEmpty()) answer = -1000;

                    else answer = Integer.parseInt(answerText);

                    //Check answer correctness and update score based on result
                    if (generator.correct(currentQ) == answer) {
                        score += 1;
                        actualAnswer.setText("Actual Answer:");
                    }

                    //If answer is wrong display correct answer
                    else actualAnswer.setText("Actual Answer: " + generator.correct(currentQ));

                    //Questions in hard mode
                    questionsCorrect.setText("Score: " + score);
                    currentQ = generator.generateQuestion(false, false);
                    questionField.setText(currentQ);
                    answerField.setText("");
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
        }
    }

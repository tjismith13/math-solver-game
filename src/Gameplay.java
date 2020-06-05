import javax.swing.*;
import java.awt.event.*;

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

    private QuestionGenerator generator = new QuestionGenerator();
    private String currentQ;
    private int score = 0;
    private Clock clock = new Clock();
    private String timeRemaining;

    public Gameplay() {

        clock.init(60);
        timeRemaining = String.valueOf(clock.timeRemaining());

        //When start/restart is pressed
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerField.setText("");
                score = 0;
                questionsCorrect.setText("Score " + score);
                timeClock.setText(timeRemaining);
                currentQ = generator.generateQuestion(true, false);
                questionField.setText(currentQ);
                startButton.setText("Restart");
            }
        });

        //When submit is pressed
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = Integer.parseInt(answerField.getText());
                if (generator.checkCorrect(currentQ, answer)) {
                    score += 1;
                }
                
                questionsCorrect.setText("Score: " + score);
                currentQ = generator.generateQuestion(false, true);
                questionField.setText(currentQ);
                answerField.setText("");
                timeClock.setText(timeRemaining);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("frmMainScreen");
        frame.setContentPane(new Gameplay().background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
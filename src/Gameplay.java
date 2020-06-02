import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gameplay {
    private JLabel Title;
    private JLabel TimeClock;
    private JTextField AnswerField;
    private JLabel QuestionField;
    private JLabel HighScore;
    private JLabel QuestionsCorrect;
    private JButton StartButton;
    private JLabel ActionMessage;

    private QuestionGenerator generator;

    public Gameplay() {

        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        AnswerField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }
}

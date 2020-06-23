package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionWindowGUI{

    public static JFrame getQuestion(JButton questionSelected){
        JFrame questionFrame = new JFrame("Question");
        questionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        questionFrame.setSize(300, 300);
        questionFrame.setLayout(new GridLayout(3, 1));

        //font
        Font font = new Font("serif", Font.PLAIN, 20);

        //question box
        JTextArea questionContent = new JTextArea(10, 10);
        questionContent.append("The question is: " + questionSelected.getClientProperty("content"));
        questionContent.setFont(font);
        questionFrame.getContentPane().add(questionContent);
        questionContent.setEditable(false);
        questionFrame.setVisible(true);

        //correct button
        JButton correct = new JButton("Correct");
        correct.putClientProperty("frame", questionFrame);
        correct.putClientProperty("question", questionSelected);
        correct.addActionListener(new CorrectListener());
        questionFrame.getContentPane().add(correct);

        //incorrect button
        JButton incorrect = new JButton("Incorrect");
        incorrect.putClientProperty("frame", questionFrame);
        incorrect.addActionListener(new IncorrectListener());
        questionFrame.getContentPane().add(incorrect);

        return questionFrame;

    }

}

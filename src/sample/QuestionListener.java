package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionListener implements ActionListener {
    //QuestionWindowGUI question = new QuestionWindowGUI();

    @Override
    public void actionPerformed(ActionEvent e) {
        //button event triggered from
        JButton pressed = (JButton) e.getSource();

        //generate question window
        QuestionWindowGUI.getQuestion(pressed);
    }
}

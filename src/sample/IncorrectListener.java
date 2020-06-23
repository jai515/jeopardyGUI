package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class IncorrectListener implements ActionListener {
    QuestionWindowGUI question = new QuestionWindowGUI();
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton pressed = (JButton) e.getSource();
        JFrame questionFrame = (JFrame) pressed.getClientProperty("frame");

        //change current player and close window
        BoardGUI.incrementActivePlayer();
        questionFrame.dispatchEvent(new WindowEvent(questionFrame, WindowEvent.WINDOW_CLOSING));
    }
}
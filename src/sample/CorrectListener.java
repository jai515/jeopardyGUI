package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class CorrectListener implements ActionListener {
    QuestionWindowGUI question = new QuestionWindowGUI();
    @Override
    public void actionPerformed(ActionEvent e) {
        // get button that opened question set to invisible
        JButton pressed = (JButton) e.getSource();
        JFrame questionFrame = (JFrame) pressed.getClientProperty("frame");
        JButton questionSelected = (JButton) pressed.getClientProperty("question");
        //questionSelected.setText("Answered");
        questionSelected.setVisible(false);

        //increment score
        BoardGUI.getActivePlayer().setScore(
                BoardGUI.getActivePlayer().getScore() +
                        Integer.parseInt(questionSelected.getClientProperty("value").toString())
        );

        //update scoreboard and close window
        BoardGUI.updateScoreBoard(BoardGUI.getActivePlayer());
        questionFrame.dispatchEvent(new WindowEvent(questionFrame, WindowEvent.WINDOW_CLOSING));
    }
}
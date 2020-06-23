package sample;

import javax.swing.*;
import java.awt.*;

public class PlayerAddGUI {

    public JFrame addPlayer(){
        JFrame newPlayer = new JFrame("Add a Player");
        newPlayer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newPlayer.setSize(300, 300);
        newPlayer.setLayout(new GridLayout(2, 1));

        JTextArea playerName = new JTextArea(5, 5);
        playerName.append("Player Name");
        newPlayer.getContentPane().add(playerName);

        JButton submit = new JButton("Submit");
        newPlayer.getContentPane().add(submit);
        submit.addActionListener(new addPlayerSubmitListener());

        newPlayer.setVisible(true);

        return newPlayer;

    }
}

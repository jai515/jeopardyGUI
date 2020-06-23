package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayerListener implements ActionListener {
    public PlayerAddGUI addPlayer = new PlayerAddGUI();
    @Override
    public void actionPerformed(ActionEvent e) {
        addPlayer.addPlayer();

    }
}

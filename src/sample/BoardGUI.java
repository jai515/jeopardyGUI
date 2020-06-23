package sample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BoardGUI {
    JFrame boardFrame;
    JPanel main;
    public static int activePlayer;
    static ArrayList<Player> playerList = new ArrayList<>();
    static Map<Integer, JButton> buttonMap = new HashMap<>();
    JTextArea title;
    JTextArea players;
    private static JTextArea activePlayerDisplay;
    JPanel scoreboard;
    static ArrayList<JTextArea> playerDisplay = new ArrayList<>();
    static ArrayList<JTextArea> playerScoreDisplay = new ArrayList<>();


    BoardGUI(Collection<String> playerInputList, QuestionBank questionBank){
        //frame of game
        boardFrame = new JFrame("Jeopardy");
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame.setSize(500,900);
        boardFrame.setLayout(new GridLayout(1, 1));

        //main panel to add to
        main = new JPanel();
        boardFrame.getContentPane().add(main);

        //board title
        title = new JTextArea("Welcome to JParty");
        title.setEditable(false);
        main.add(title);
        main.setLayout(new GridLayout(questionBank.getSize()+2, 1));

       // NOT DISPLAYED
        players = new JTextArea(1+playerInputList.size(), 1);
        players.append("Players are: ");
        for(String player: playerInputList){
            players.append(player + ",");
            playerList.add(new Player(player));
        }
        //main.add(players);
        players.setEditable(false);

        // create scoreboard panel
        scoreboard = new JPanel();
        scoreboard.setLayout(new GridLayout(2, playerInputList.size()));
        main.add(scoreboard);

        // add text area to lists
        for(Player player: playerList){
            playerDisplay.add(new JTextArea(player.getName()));
            playerScoreDisplay.add(new JTextArea(Integer.toString(player.getScore())));
        }

        //add text area lists to scoreboard, can be done in one loop.
        for(JTextArea player: playerDisplay){
            scoreboard.add(player);
        }
        for(JTextArea player: playerScoreDisplay){
            scoreboard.add(player);
        }

        //NOT DISPLAYED
        activePlayerDisplay = new JTextArea(1, 1);
        activePlayerDisplay.setText(playerList.get(activePlayer).getName()+ "|" +
        playerList.get(activePlayer).getScore());
        //main.add(activePlayerDisplay);


        //initial player turn coloring
        playerDisplay.get(0).setBackground(Color.BLUE);
        playerDisplay.get(0).setForeground(Color.ORANGE);

        //add Question buttons to main panel
        //for(int i = 1; i <= questionBank.getSize(); i++){
        for(Map.Entry<Integer, Questions> question: questionBank.getBank().entrySet()){
            JButton button = new JButton(Integer.toString(question.getValue().getDollarValue()));
            buttonMap.put(question.getKey(), button);
            button.putClientProperty("content", question.getValue().getQuestionContent());
            button.putClientProperty("value", question.getKey());
            button.setBackground(Color.BLUE);
            button.setForeground(Color.ORANGE);
            main.add(button);
            button.addActionListener(new QuestionListener());
        }

        //set board to be visible
        boardFrame.setVisible(true);
    }

    public JFrame getBoardFrame(){
        return boardFrame;
    }

    //returns the current active player object
    public static Player getActivePlayer() {
        return (playerList.get(activePlayer));
    }

    //changes the active player to the next player in the list
    public static void incrementActivePlayer(){
        //reset color
        playerDisplay.get(activePlayer).setBackground(Color.WHITE);
        playerDisplay.get(activePlayer).setForeground(null);

        activePlayer = (activePlayer+1)%playerList.size();
        activePlayerDisplay.setText(getActivePlayer().getName()+ "|" +
                getActivePlayer().getScore());

        //color active player
        playerDisplay.get(activePlayer).setBackground(Color.BLUE);
        playerDisplay.get(activePlayer).setForeground(Color.ORANGE);
    }

    //updates the scoreboard after the score has changed
    public static void  updateScoreBoard(Player player){
        activePlayerDisplay.setText(getActivePlayer().getName()+ "|" +
                getActivePlayer().getScore());
        playerScoreDisplay.get(activePlayer).setText(Integer.toString(getActivePlayer().getScore()));
    }

}

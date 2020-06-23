package sample;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> players = new ArrayList<>();
    public static QuestionBank bank = new QuestionBank();




    public static void main(String[] args) throws IOException, InterruptedException  {
        bank.addQuestion(100, "What is a ctor?");
        bank.addQuestion(200,"What is a jvm?");
        bank.addQuestion(300, "What is a stream?");
        bank.addQuestion(400, "What is a jar?");

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players? (1-5)");
        int numberPlayers = Integer.parseInt(scanner.next());
        for(int i = 1; i <= numberPlayers; i++){
            System.out.println("What is player "+ i +"'s name?");
            String name = scanner.next();
            players.add(name);
        }

        BoardGUI newGame = new BoardGUI(players, bank);
        //JFrame gameBoard = newGame.getBoard();
    }
}
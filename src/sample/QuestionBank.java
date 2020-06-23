package sample;

import java.util.*;

public class QuestionBank {
    private static LinkedHashMap<Integer, Questions> bank = new LinkedHashMap<>();
    private int size;

    public void addQuestion(int dollarValue,  String content){
        Questions question = new Questions(dollarValue, content);
        bank.put(dollarValue, question);
        size += 1;
    }

    public static  Questions getQuestion(int dollarValue){
        return bank.get(dollarValue);
    }

    public HashMap<Integer, Questions> getBank(){
        return bank;
    }

    public int getSize(){
        return size;
    }

}

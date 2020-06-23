package sample;

public class Questions {
    private int dollarValue;
    private String questionContent;

    Questions(int dollarValue, String questionContent){
        this.dollarValue = dollarValue;
        this.questionContent = questionContent;
    }

    public int getDollarValue() {
        return dollarValue;
    }

    public void setDollarValue(int dollarValue) {
        this.dollarValue = dollarValue;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }
}

package com.triviagameproj;

public class Question {
    private String mQuestion, mAnswer;
    private int mPointValue;

    /**
     * Question is a three qrgument constructor which initializes the three instance variables:
     * @param q         The question
     * @param a         The answer
     * @param points    The pointvalue of the question if answered correctly
     */
    public Question (String q, String a, int points) {
        this.mQuestion = q;
        this.mAnswer = a;
        this.mPointValue = points;
    }

    /**
     * setter method for the question
     * @param question      String taken in that is used to change this.mQuestion
     */
    public void setQuestion (String question) {
        this.mQuestion = question;
    }

    /**
     * setter method for the answer
     * @param answer        String taken that is used to change the String for this.mAnswer
     */
    public void setAnswer (String answer) {
        this.mAnswer = answer;
    }

    /**
     * setter method for the pointvalue
     * @param point         Int taken that is used to change the value for this.mPointValue
     */
    public void setPointValue (int point) {
        this.mPointValue = point;
    }

    /**
     * getter method for question
     * @return      Returns a string which is the value of mQuestion
     */
    public String getQuestion (){return mQuestion;}

    /**
     * getter method for answer
     * @return      Returns a string which is the value of mAnswer
     */
    public String getAnswer () {return mAnswer;}

    /**
     * getter method for point-value
     * @return      Returns an int which is the value of mPointValue
     */
    public int getPointValue () {return mPointValue;}
}

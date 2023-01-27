package com.triviagameproj;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;

/**
 * driver class carries main function of the program
 */

public class driver extends javax.swing.JFrame{
    private JPanel jPanel;
    private JLabel question;
    private JTextField answer;
    private JButton submit;
    private JButton quit;
    private JLabel upscore;
    public static final int WIDTH = 900;
    public static final int HEIGHT = 300;
    ArrayList<Question> questions = new ArrayList<>(10);
    int questionNum = 0;
    int score = 0;
    boolean right = false;
    boolean start = true; // check so point isnt given at beginning

    /**
     * driver initializes GUI and all data to be used
     * @throws FileNotFoundException
     */

    public driver() throws FileNotFoundException {
        super("Welcome to the Balkan Peninsula Trivia Game - Uživati!");
        initComponents();
        if(start){initData();}
        update();
    }

    /**
     * update() updates text to be used in GUI for the question JLabel.
     */
    public void update() {
        if(questionNum<questions.size()) {
            question.setText(questions.get(questionNum).getQuestion());
            answer.setText("Your answer? ");
            if (!start) {
                if (right) {
                    upscore.setText("That is correct! The correct answer is " +
                            questions.get(questionNum - 1).getAnswer() + ". Your score is " + score);
                } else {
                    upscore.setText("Sorry, but no. The correct answer is " + questions.get(questionNum - 1).getAnswer()
                            + ". Your score is " + score);
                }
            }
        }
        else {
            if(questionNum==questions.size()) {
                question.setText(questions.get(questionNum-1).getQuestion());
                if (right) {
                    upscore.setText("That is correct! The correct answer is " +
                            questions.get(questionNum - 1).getAnswer() + ". Your score is " + score + ". Game Over.");
                } else {
                    upscore.setText("Sorry, but no. The correct answer is " + questions.get(questionNum - 1).getAnswer()
                            + ". Your score is " + score + ". Game Over");
                }
            }
            else {
                question.setText("No more questions.");
                answer.setText("");
                upscore.setText("Game Over. Goodbye!");
            }

        }

    }

    /**
     * initData() takes data from text file and puts it into an arraylist of Question's using the readerwriter class
     * @throws FileNotFoundException
     */

    public void initData() throws FileNotFoundException{
        readerwriter doc = new readerwriter();
        questions = (doc.setList("mystuff.txt"));
    }

    /**
     * initComponents() initializes all components to be used in GUI. Provides data, actionlisteners, and
     * formatting style.
     */

    private void initComponents() {
        jPanel = new JPanel(new GridBagLayout());
        jPanel.setBackground(Color.getHSBColor(41, 190, 254));
        question = new JLabel();
        upscore = new JLabel();
        answer = new JTextField("Your answer? ", 20);
        submit = new JButton("Check Answer");
        quit = new JButton("Quit Game");
        JPanel btnPanel = new JPanel(new GridBagLayout());
        quit.addActionListener(this::submitActionPerformed);
        submit.addActionListener(this::submitActionPerformed);


        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        jPanel.add(question, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 40;
        jPanel.add(answer, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        btnPanel.add(submit, c);
        c.gridx = 1;
        btnPanel.add(quit, c);
        c.gridx = 0;
        c.gridy = 2;
        jPanel.add(upscore, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.ipadx = 3;
        jPanel.add(btnPanel, c);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        add(jPanel);

    }

    /**
     * submitActionPerformed takes an ActionEvent from the user's input and uses this input to determine if user's input
     * is correct and if the program should quit based on if user clicked on the submit button or quit button.
     * @param e         ActionEvent
     * @return          void
     */

    public void submitActionPerformed(ActionEvent e) {
        start = false;
        String s = e.getActionCommand();
        if(s.equals("Check Answer")) {
            if(questionNum<questions.size()) {
                if (questions.get(questionNum).getAnswer().equalsIgnoreCase(answer.getText().trim())) {
                    score += questions.get(questionNum).getPointValue();
                    right = true;
                    //congrats message
                } else {
                    right = false;
                }
            }
            questionNum++;
            update();
        }
        else if (s.equals("Quit Game")) {
            System.exit(0);
        }
    }
    /**
     * main runs the program
     * @throws          FileNotFoundException if readerwriter is unable to find document.
     * @param args      Command-line arguments
     * @return          Returns void
     */
    public static void main (String args[]) throws FileNotFoundException {
        new driver().setVisible(true);
    }
}

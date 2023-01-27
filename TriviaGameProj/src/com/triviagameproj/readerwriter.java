package com.triviagameproj;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileInputStream;

/**
 * readerwriter class is used to create an arraylist of Questions from a document.
 */
public class readerwriter {
    /**
     * setList creates a list from a list of questions, answers, and pointvalues from a given document
     * @param location      Given document name, this method will create an arraylist of questions from data in doc
     * @return              Returns an arraylist of Questions from data gathered in doc
     * @throws FileNotFoundException        Throws FileNotFoundExcpetion if file cannot be found
     */
    public ArrayList<Question> setList(String location) throws FileNotFoundException {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(location));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
            System.exit(0);
        }
        ArrayList<Question> list = new ArrayList<>(20);
        int i = 0;
        while(inputStream.hasNextLine()) {
            Question current = new Question(inputStream.nextLine(), inputStream.nextLine(), inputStream.nextInt());
            if(inputStream.hasNextLine()) {inputStream.nextLine();}
            list.add(i, current);
            i++;
        }
        inputStream.close();
        return list;
    }
}

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class wordHunt {

    String wordToGuess = "";
    char letterByLetter[];
    int randomLine;
    int fileLimit = 0;
    int charNumber;
    File guessWord;
    boolean wantLine = false;
    boolean wantHelp = false;
    int hasHint = 0;

    class FileSystem
    {
        private String fileName;

        private int lineLimit;

        public FileSystem(String Path, int fileLimit) {
            this.fileName = Path;
            this.lineLimit = fileLimit;
        }

        private void isPicked()
        {
            guessWord = new File(fileName);
            fileLimit = lineLimit;
        }
    }

    public void characterCount(int charCount) throws IOException {
        letterByLetter = new char[charCount];
        game();
    }

    public void inputChecker(String userInput)
    {

        if(userInput.length() == 1)
        {
            char userLetter = userInput.charAt(0); //assigns the first character of the string which would only be a single letter

            for(int i = 0; i < letterByLetter.length; i++)
            {
                if(userLetter == wordToGuess.charAt(i))
                {
                    letterByLetter[i] = userLetter;
                }
            }
        }
        else
        {

            //fill with word shortcuts and functions
            if(userInput.charAt(0) == 'h' && userInput.charAt(1) == 'e' && userInput.charAt(2) == 'l' && userInput.charAt(3) == 'p')
            {
                helpKeyword();
            }
            else if(userInput.charAt(0) == 'l' && userInput.charAt(1) == 'i' && userInput.charAt(2) == 'n' && userInput.charAt(3) == 'e')
            {
                wantLine = true;
            }
            else if(userInput.charAt(0) == 'h' && userInput.charAt(1) == 'i'&& userInput.charAt(2) == 'n' && userInput.charAt(3) == 't')
            {
                Random random = new Random();



                    charNumber = random.nextInt(letterByLetter.length + 1);

                    letterByLetter[charNumber] = wordToGuess.charAt(charNumber);






            }
        }
    }


    public void helpKeyword()
    {
        for(int i = 0; i < wordToGuess.length(); i++)
        {
            letterByLetter[i] = wordToGuess.charAt(i);
        }

    }

    public void game() throws IOException
    {
        //For 3 Letter Words
        FileSystem threeWord = new FileSystem("3_Letter_Words.txt", 1029);

        //For 4 Letter Words
        FileSystem fourWord = new FileSystem("4_Letter_Words.txt", 2500);

        //For 5 Letter Words
        FileSystem fiveWord = new FileSystem("5_Letter_Words.txt", 2500);

        //For 6 Letter Words
        FileSystem sixWord = new FileSystem("6_Letter_Words.txt", 2500);

        //For 7 Letter Words
        FileSystem sevenWord = new FileSystem("7_Letter_Words.txt", 2500);

        try{
            switch (letterByLetter.length)
            {
                case 3:
                    threeWord.isPicked();
                    break;
                case 4:
                    fourWord.isPicked();
                    break;
                case 5:
                    fiveWord.isPicked();
                    break;
                case 6:
                    sixWord.isPicked();
                    break;
                case 7:
                    sevenWord.isPicked();
                    break;
            }
            FileReader readfile = new FileReader(guessWord);
            BufferedReader readbuffer = new BufferedReader(readfile);

            Random getLine = new Random();
            randomLine = getLine.nextInt(fileLimit - 1) + 1;

            for(int i = 0; i < fileLimit; i++)
            {
                if(i == randomLine)
                {
                    wordToGuess = readbuffer.readLine();
                }
                else
                {
                    readbuffer.readLine();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



        wordToGuess = wordToGuess.toLowerCase();
        charArrayDeveloper();
    }

    public void charArrayDeveloper()
    {
        for(int i = 0; i < wordToGuess.length(); i++)
        {
            letterByLetter[i] = '_';
        }
    }

    public String toString()
    {
        String str = "";

        for(int i = 0; i < letterByLetter.length; i++)
        {
            str += Character.toString(letterByLetter[i]) + " ";

        }

        if(wantLine == true)
        {
            str += " " + (randomLine + 1);
        }



        return str;
    }

    public boolean wingGame()
    {
        int amountCorrect = 0;

        for(int i = 0; i < letterByLetter.length; i++)
        {
            if(letterByLetter[i] == wordToGuess.charAt(i))
            {
                amountCorrect++;
            }
        }

        if(amountCorrect == wordToGuess.length())
        {
            return true;
        }
        return false;
    }


}


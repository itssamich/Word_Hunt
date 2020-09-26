import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

class mainWindow extends JPanel {

    private static int Height = 800;
    private static int Width = 600;
    private wordHunt game = new wordHunt();
    private JFrame window = new JFrame("Word Guesser");
    private JPanel homeScreen = new JPanel();
    private JPanel gameWindow = new JPanel();

    //Main Window
    JLabel startLabel = new JLabel("Please Select the difficulty...");


    //Easy Options
    JButton threeWord = new JButton("3 Letter Word");
    JButton fourWord = new JButton("4 Letter Word");
    //Medium Options
    JButton fiveWord = new JButton("5 Letter Word");
    JButton sixWord = new JButton("6 Letter Word");
    //Hard Option
    JButton sevenWord = new JButton("7 Letter Word");


    //Game Window
    JButton goBack = new JButton("Back to menu");
    JButton letterChecker = new JButton("Check!");
    JTextField letterEnter = new JTextField();
    JLabel word = new JLabel("");

    public mainWindow()
    {

        startHomeScreen();


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(Height/3, Width/2);
        window.add(this);
        window.setVisible(true);
    }

    public void startHomeScreen()
    {


        window.setContentPane(homeScreen);
        homeScreen.setLayout(null);


        //JMenuItem easyOption = new JMenuItem("Easy");


        startLabel.setBounds((Width - (Width - 0)), (Height - (Height)), 250, 25);
        homeScreen.add(startLabel);

        //28 pixel difference between the height of buttons
        threeWord.setBounds((Width - (Width - 50)),(Height - (Height - 50)) , 125, 25);
        homeScreen.add(threeWord);

        fourWord.setBounds((Width - (Width - 50)),(Height - (Height - 78)) , 125, 25);
        homeScreen.add(fourWord);

        fiveWord.setBounds((Width - (Width - 50)),(Height - (Height - 106)) , 125, 25);
        homeScreen.add(fiveWord);

        sixWord.setBounds((Width - (Width - 50)),(Height - (Height - 134)) , 125, 25);
        homeScreen.add(sixWord);

        sevenWord.setBounds((Width-(Width -50)), (Height - (Height - 162)), 125, 25);
        homeScreen.add(sevenWord);


        threeWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.characterCount(3);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                startGame();

            }
        });

        fourWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.characterCount(4);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                startGame();

            }
        });

        fiveWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.characterCount(5);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                startGame();

            }
        });

        sixWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.characterCount(6);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                startGame();

            }
        });

        sevenWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.characterCount(7);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                startGame();

            }
        });

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(Height/3, Width/2);
        window.add(this);
        window.setVisible(true);
    }

    public void startGame()
    {
        window.invalidate();
        window.setContentPane(gameWindow);
        window.validate();

        Dimension textBox = new Dimension(125, 25);


        word.setText(game.toString());
        word.setFont(word.getFont().deriveFont(18.0f));


        //gameWindow.setLayout(null);
        gameWindow.add(goBack);
        gameWindow.add(word);


        gameWindow.add(letterChecker);
        letterEnter.setPreferredSize(textBox);
        gameWindow.add(letterEnter);



        letterChecker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = letterEnter.getText();
                game.inputChecker(userInput);
                updateGame();
            }
        });

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letterEnter.setText("");
                startHomeScreen();

            }
        });

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(Height, Width);
        window.add(this);
        window.setVisible(true);
    }

    public void updateGame()
    {
        letterEnter.setText("");
        word.setText(game.toString());
        if(game.wingGame())
        {
            JOptionPane.showMessageDialog(null, "You Win!");
        }

    }

    public static void main(String args[])
    {
        new mainWindow();
    }
}

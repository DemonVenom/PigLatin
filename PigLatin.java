
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PigLatin extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JLabel instructLabel;
    private JTextField inputTextField;
    private JTextField outputTextField;
    private JButton convertButton;
    private JButton exitButton;


    // Create constructor of the kilometer converter window

    public PigLatin() {

        // Set the window title
        super("Pig Latin Converter");

        // Set the border layout to default
        setLayout(new BorderLayout());
        // Set the flow layout to default
        setLayout(new FlowLayout());
        // Set the width (950) and height (200) of window
        setSize(950, 200);
        // Set the windows to close when the close button is pressed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Call the createPanel1 method
        createPanel1();
        // Add the panel to the frame
        add(panel1);

        // Call the createPanel2 method
        createPanel2();
        // Add the panel to the frame
        add(panel2);

        // Make the window visible to the user
        setVisible(true);
    }


    // Create method to allow the user to input kilometer value

    private void createPanel1() {

        // Create a new label, prompting the user to input normal english string phrase
        instructLabel = new JLabel("Phrase to be Converted: ");

        // Create a new text field, measured at 25 characters long
        inputTextField = new JTextField(25);
        // Create a new action listener, allows program to start calculation
        inputTextField.addActionListener(new ConvertHandler());

        // Create a new button, allows user to start calculation
        convertButton = new JButton("Convert");
        // Create a new action listener, allows program to start calculation
        convertButton.addActionListener(new ConvertHandler());


        // Create a new panel, using the panel1 reference
        panel1 = new JPanel();

        // Add label, text field, and button to panel1
        panel1.add(instructLabel);
        panel1.add(inputTextField);
        panel1.add(convertButton);
    }


    // Create method to get the mile value and exit program

    private void createPanel2() {


        // Create a new text field, measured at 50 characters long
        outputTextField = new JTextField(50);
        // Set attributes to the text field, making it uneditable and gray
        outputTextField.setBackground(Color.LIGHT_GRAY);
        outputTextField.setEditable(false);

        // Create a new button, allows user to start exit program
        exitButton = new JButton("Exit");
        // Create a new action listener, allows program to exit the program
        exitButton.addActionListener(new ExitHandler());


        // Create a new panel, using the panel2 reference
        panel2 = new JPanel();

        // Add text field, label, and button to panel2
        panel2.add(outputTextField);
        panel2.add(exitButton);
    }


    // Create class to handle Pig Latin conversion

    private class ConvertHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            String userInput = inputTextField.getText();

            // Split the string into an array of words
            String [] words = userInput.split("\\s");

            // Create output string
            String output = "";

            // Create for loop to iterate through each word in the words array
            for (int i = 0; i < words.length; i++) {

                // Call the convertWord method, inputting the word at array index i
                // Assign the return result to string pigLatinWord
                String pigLatinWord = convertWord(words[i]);

                // Append the pigLatinWord to the end of the results so far with a space at the end
                output = String.format("%s%s ", output, pigLatinWord);
            }

            // Send output to the outputTextField
            outputTextField.setText(output);
        }
    }


    // Create method to convert each word (string) to Pig Latin

    public static String convertWord(String word) {

        // Create integer variable to use as the position of the vowel
        int position = -1;
        // Create character variable to use to store the letter into
        char character;

        // Set all the words to lowercase
        String lowerCaseWord = word.toLowerCase();


        // Create for loop to iterate through each letter in the word
        for (int i = 0; i < lowerCaseWord.length(); i++) {

            // Store word letter into variable
            character = lowerCaseWord.charAt(i);

            // Under the condition that the character is a vowel
            if (isVowel(character) == true) {

                // Set the position of the vowel to the position variable
                position = i;

                // Exit the for loop
                break;
            }
        }

        // If the position of the first variable is 0
        if (position == 0) {

            // just add '-ay' to the end of the word
            return String.format("%s-ay", lowerCaseWord);
        }
        // For anything else...
        else {

            // Take all characters in the word beginning from the first vowel and store them into variable
            String a = lowerCaseWord.substring(position);
            // Take all characters in the word before the first vowel and store them into variable
            String b = lowerCaseWord.substring(0, position);

            // Break up the two sections, adding '-ay' at the end
            return String.format("%s-%say", a, b);
        }
    }


    // Create method to detect for vowels

    public static Boolean isVowel(char ch) {

        // Under the condition that the character is an 'a', 'e', 'i', 'o', 'u', or 'y'
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {

            // Return the boolean true
            return true;
        }
        // If not, return the boolean false
        return false;
    }



    // Create class to end the program

    private class ExitHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            // Exits with status code 0
            System.exit(0);
        }
    }


}

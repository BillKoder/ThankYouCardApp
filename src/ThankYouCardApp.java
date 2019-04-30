// Next I want to create a UI for the user to enter the information
// Allow the program to read the information from a spreadsheet
// Add a card design to print
// Add e-mail functionality to be able to send cards through web
// Make this app available on the web
// Make this into an app for phones and tablets
    // when being used by tablet allow for user to write input with stylist


// Scanner is used to take user input
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


public class ThankYouCardApp {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JTextField textField;

    public static void main(String[] args) {

        new ThankYouCardApp();
    }

    private ThankYouCardApp() {
        gui();
    }

    private void gui() {
        frame = new JFrame("Thank You Card App");
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel= new JPanel();
        panel.setBackground(Color.YELLOW);

        label = new JLabel("How many people did you receive a gift from?");
        textField = new JTextField(3);
        button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                takeInNumberOfGifters(textField.getColumns());
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);


        frame.add(panel);
    }

    private void takeInNumberOfGifters(int gifters){

        // Variable declarations
        String[] name, gift;
        int numberOfgifters;
        Scanner scanner = new Scanner(System.in);

        // Ask user for amount a names and gifts needed
        //System.out.println("How many people did you receive a gift from?");
        //numberOfgifters = Integer.parseInt(scanner.nextLine());

        //Changed numberOfgifters to gifters
        name = new String[gifters];
        gift = new String[gifters];

        // A loop for users to enter names with gifts
        for (int i = 0; i < gifters; i++) {
            System.out.println("Enter name:");
            name[i] = scanner.nextLine();
             System.out.println("Enter gift: ");
            gift[i] = scanner.nextLine();

            // Formatting gift strings
            if (gift[i].contains("a ") || gift[i].contains("A ")) {
               gift[i] = gift[i].replaceAll("a ", "the ");
               gift[i] = gift[i].replaceAll("A ", "the ");
            }
            if (!gift[i].startsWith("the ")){
                gift[i] = "the " + gift[i];
            }
        }

        // Print Thank you with names and gifts
        for (int i = 0; i < gifters; i++) {
            System.out.println("Thank you " + name[i] + " for " + gift[i]);
        }

    }
}

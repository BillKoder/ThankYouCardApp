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
    private int numberOfGifters;
    String[] names;
    String[] gifts;

    public static void main(String[] args) {

        SwingUtilities.invokeLater((new Runnable() {
            @Override
            public void run() {
                new ThankYouCardApp();
            }
        }));
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
                numberOfGifters = Integer.parseInt(textField.getText());
                panel.removeAll();
                enterNameAndGift(numberOfGifters);
                frame.revalidate();
                frame.repaint();
               // takeInNumberOfGifters(numberOfGifters);
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

    private void enterNameAndGift(int numberOfGifters){

        JTextField[] textFieldNames = new JTextField[numberOfGifters];
        JTextField[] textFieldGifts = new JTextField[numberOfGifters];
        String[] names = new String[numberOfGifters];
        String[] gifts = new String[numberOfGifters];
        frame.remove(panel);
        JPanel panelB = new JPanel();
        Color lightBlue = new Color(86,156,255);
        panelB.setBackground(lightBlue);

        JLabel labelName = new JLabel("Enter a Name:");
        JLabel labelGift = new JLabel("Enter gift: ");
        JButton SubmitButton = new JButton("Submit");
        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < numberOfGifters; i++){
                    names[i] = textFieldNames[i].getText();
                    gifts[i] = textFieldGifts[i].getText();
                }
                panelB.removeAll();
                thankYouMessage(numberOfGifters, names, gifts, panelB);
                frame.revalidate();
                frame.repaint();
            }
        });

        panelB.add(labelName);
        panelB.add(labelGift);

        for (int i = 0; i < numberOfGifters; i++){
            textFieldNames[i] = new JTextField("name", 20);
            textFieldGifts[i] = new JTextField("gift", 20);
            panelB.add(textFieldNames[i]);
            panelB.add(textFieldGifts[i]);

        }

        panelB.add(SubmitButton);
        frame.add(panelB);
    }

    private void thankYouMessage(int numberOfGifters, String[] names, String[] gifts, JPanel panel1) {
        JLabel[] thankYous = new JLabel[numberOfGifters];

        for (int i = 0; i < numberOfGifters; i++){
            thankYous[i] = new JLabel("Thank you " + names[i] + " for " + gifts[i]);
            panel1.add(thankYous[i]);
        }
    }
}

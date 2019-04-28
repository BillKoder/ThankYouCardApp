// Next I want to create a UI for the user to enter the information
// Allow the program to read the information from a spreadsheet
// Add a card design to print
// Add e-mail functionality to be able to send cards through web
// Make this app available on the web
// Make this into an app for phones and tablets
    // when being used by tablet allow for user to write input with stylist


import java.util.Scanner;

public class ThankYouCardApp {
    public static void main(String[] args) {

        String[] name, gift;
        int numberOfgifters;
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many people did you receive a gift from?");
        numberOfgifters = Integer.parseInt(scanner.nextLine());
        name = new String[numberOfgifters];
        gift = new String[numberOfgifters];
        for (int i = 0; i < numberOfgifters; i++) {
            System.out.println("Enter name:");
            name[i] = scanner.nextLine();
             System.out.println("Enter gift: ");
            gift[i] = scanner.nextLine();

            if (gift[i].contains("a ") || gift[i].contains("A ")) {
               gift[i] = gift[i].replaceAll("a ", "the ");
               gift[i] = gift[i].replaceAll("A ", "the ");
            }
            if (!gift[i].startsWith("the ")){
                gift[i] = "the " + gift[i];
            }
        }
        for (int i = 0; i < numberOfgifters; i++) {
            System.out.println("Thank you " + name[i] + " for " + gift[i]);
        }
    }
}

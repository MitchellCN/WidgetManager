package com.theironyard;

import java.util.Scanner;

/**
 * This class controls menus and user input.
 */
public class MenuService {

    public static final int LIST_WIDGETS = 1;
    public static final int CREATE_WIDGET = 2;
    public static final int VIEW_WIDGET = 3;
    public static final int EDIT_WIDGET = 4;
    public static final int DELETE_WIDGET = 5;
    public static final int QUIT = 6;

    Scanner scanner = new Scanner(System.in);

    /**
     * This method displays the provided prompt and then waits for a user to
     * provide input. The input must be a valid integer. If not, an error
     * message is displayed and the user is prompted to try again. If the input
     * is valid, then the value entered is returned.
     *
     * @param prompt The prompt displayed to the user.
     * @return The value entered by the user
     */
    public int waitForInt(String prompt){
        // display the prompt to the user
        System.out.print(prompt.trim() + " ");

        // check if the next input is an int.
        if(!scanner.hasNextInt()){
            // if the next input is not an int, read it as a string to show in an error message
            String badInput = scanner.next();

            // show an error message
            System.out.printf("\nError: '%s' is not a valid number. Please try again.\n\n", badInput);

            // recursively prompt the user again
            return waitForInt(prompt);
        } else {
            // return the int the user provided
            return scanner.nextInt();
        }

    }

    public int promptForMainMenuSelection() {

        System.out.println("\n" +
                "-- Main Menu --\n" +
                "\n" +
                "1) List widgets\n" +
                "2) Create a widget\n" +
                "3) View widget details\n" +
                "4) Edit a widget\n" +
                "5) Delete a widget\n" +
                "6) Quit \n");

        int choice = waitForInt("Please choose an option:");

        if(choice >= 1 && choice <= 6){
            return choice;
        } else {

            System.out.println("\nError: Sorry, that isn't a valid option.");

            return promptForMainMenuSelection();
        }

    }
}

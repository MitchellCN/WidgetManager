package com.theironyard;

import java.util.ArrayList;
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

    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

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

    /**
     * This method displays the main menu options and returns whatever item the
     * user selects.
     *
     * @return The number for the menu item the user selected.
     */
    public int promptForMainMenuSelection() {

        System.out.println("\n" +
                "-- Main Menu --\n" +
                "\n" +
                "1)\tList widgets\n" +
                "2)\tCreate a widget\n" +
                "3)\tView widget details\n" +
                "4)\tEdit a widget\n" +
                "5)\tDelete a widget\n" +
                "6)\tQuit \n");

        int choice = waitForInt("Please choose an option:");

        if(choice >= 1 && choice <= 6){
            return choice;
        } else {

            System.out.println("\nError: Sorry, that isn't a valid option.");

            return promptForMainMenuSelection();
        }

    }

    /**
     * This method prints out the provided list of widgets, along with a number.
     * Note that the number is one more than the index of the widget in the list.
     *
     * @param widgets This is an ArrayList of Widgets to list
     */
    public void printWidgetList(ArrayList<Widget> widgets) {

        System.out.println("\n-- Widget List --");

        // are there any widgets to display?
        if(widgets.size() == 0) {
            // If not, show a friendly message
            System.out.println("\nThere are no widgets to list.");

        } else {
            // If so, display them!
            System.out.printf("\n#)\t%-25s\tType\n", "Name");

            int x = 1;

            // loop over the widgets and print them out, one at a time.
            for(Widget widget : widgets){
                System.out.printf("%s)\t%-25s\t%s\n",
                        x,
                        widget.name,
                        widget.type);

                x++;
            }
        }


    }

    /**
     * This method prompts the user for information about a new Widget,
     * constructs it, and returns it.
     *
     * @return A new Widget
     */
    public Widget promptForNewWidget() {

        System.out.println("\n-- Create a Widget --");

        System.out.println("\nPlease provide the following information about your new widget.\n");

        return new Widget(
                promptForString("Name", true),
                promptForString("Description", false),
                promptForString("Type", true),
                promptForInt("Weight"),
                promptForInt("Inventory")
        );

    }

    private int promptForInt(String prompt) {

        System.out.printf(prompt + ": ");

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            String badInput = scanner.next();

            System.out.printf("'%s' is not a whole number.", badInput);

            return promptForInt(prompt);
        }
    }

    private int promptForInt(String prompt, int defaultValue) {
        System.out.printf(prompt + "[%s]: ", defaultValue);

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            String badInput = scanner.next().trim();

            if(badInput.equals("")){
                return defaultValue;
            } else {
                return promptForInt(prompt, defaultValue);
            }
        }
    }

    private String promptForString(String prompt, boolean required) {

        System.out.printf(prompt + ": ");

        String input = scanner.next().trim();

        if(required && input.length() == 0){
            System.out.println("\nThis field is required.\n");

            return promptForString(prompt, required);

        } else {
            return input;

        }
    }

    private String promptForString(String prompt, String defaultValue) {

        System.out.printf(prompt + "[%s]: ", defaultValue);

        String input = scanner.next().trim();

        if(input.length() > 0) {
             return input;
        } else {
            return defaultValue;
        }
    }

    public int promptForWidgetToView() {

        System.out.println("\n-- View a Widget --");

        System.out.println("\nPlease enter the number for the widget you wish to view.\n");


        // we're subtracting 1 from the widget ID because the printWidgetList() method above starts counting at 1, not 0.
        return promptForInt("Widget Id") - 1;
    }

    public int promptForWidgetToEdit() {

        System.out.println("\n-- Edit a Widget --");

        System.out.println("\nPlease enter the number for the widget you wish to edit.\n");

        // we're subtracting 1 from the widget ID because the printWidgetList() method above starts counting at 1, not 0.
        return promptForInt("Widget Id") - 1;
    }

    public int promptForWidgetToDelete() {

        System.out.println("\n-- Delete a Widget --");

        System.out.println("\nPlease enter the number for the widget you wish to delete.\n");

        // we're subtracting 1 from the widget ID because the printWidgetList() method above starts counting at 1, not 0.
        return promptForInt("Widget Id") - 1;
    }

    public void displayWidget(Widget widget) {
        System.out.printf("\nName: %s\n", widget.name);
        System.out.printf("Description: %s\n", widget.description);
        System.out.printf("Type: %s\n", widget.type);
        System.out.printf("Weight: %s\n", widget.weight);
        System.out.printf("Inventory: %s\n", widget.inventory);
    }

    public void displayWidgetDoesNotExistError(int id) {
        // we're adding 1 to the id because the menu service's list starts counting at 1, not 0
        System.out.printf("\nWidget '%s' does not exist!\n", id + 1);
    }

    public void promptForWidgetEdits(Widget widget) {
        widget.name = promptForString("\nName", widget.name);
        widget.description = promptForString("Description", widget.description);
        widget.type = promptForString("Type", widget.type);
        widget.weight = promptForInt("Weight", widget.weight);
        widget.inventory = promptForInt("Inventory", widget.inventory);
    }

    public void printWidgetDeleted(int id) {

        System.out.printf("\nWidget '%s' was deleted!\n", id + 1);

    }
}

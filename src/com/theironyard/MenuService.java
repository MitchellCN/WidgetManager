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

    /**
     * This is a constructor for the MenuService it requires a Scanner instance
     * be provided.
     *
     * @param scanner
     */
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
    public int waitForInt(String prompt) {
        // display the prompt to the user
        System.out.print(prompt.trim() + " ");

        // check if the next input is an int.
        if (!scanner.hasNextInt()) {
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

        // print the menu itself
        System.out.println("\n" +
                "-- Main Menu --\n" +
                "\n" +
                "1)\tList widgets\n" +
                "2)\tCreate a widget\n" +
                "3)\tView widget details\n" +
                "4)\tEdit a widget\n" +
                "5)\tDelete a widget\n" +
                "6)\tQuit \n");

        // wait for the user to provide an integer value
        int choice = waitForInt("Please choose an option:");

        // validate the integer provided
        if (choice >= 1 && choice <= 6) {
            // if it's valid, return it
            return choice;
        } else {

            // if it's not valid, print an error and...
            System.out.println("\nError: Sorry, that isn't a valid option.");

            // ... try again
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
        if (widgets.size() == 0) {
            // If not, show a friendly message
            System.out.println("\nThere are no widgets to list.");

        } else {
            // If so, display them!
            System.out.printf("\n#)\t%-25s\tType\n", "Name");

            /*
                This is a manually managed index for our list. Note that since
                there are other places in our code that reference this index we
                will have to SUBTRACT 1 from those because this starts at 1, not
                0.
             */
            int x = 1;

            // loop over the widgets and print them out, one at a time.
            for (Widget widget : widgets) {
                System.out.printf("%s)\t%-25s\t%s\n",
                        x,
                        widget.name,
                        widget.type);

                // increment our index
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

        // Note that the new Widget is created by values provided by the user.
        return new Widget(
                promptForString("Name", true),
                promptForString("Description", false),
                promptForString("Type", true),
                promptForInt("Weight"),
                promptForInt("Inventory")
        );

    }

    /**
     * This private method shows a prompt and collects an integer from the user.
     *
     * @param prompt The prompt to display.
     * @return The integer provided by the user
     */
    private int promptForInt(String prompt) {

        System.out.printf(prompt + ": ");

        // do we have an int to read?
        if (scanner.hasNextInt()) {
            // read and return the int
            return scanner.nextInt();

        } else {
            // the input was not an int. read the bad input and display an error
            String badInput = scanner.next();

            System.out.printf("'%s' is not a whole number.", badInput);

            // re-prompt the user
            return promptForInt(prompt);
        }
    }

    /**
     * This method prompts the user for an int, but specifies a default value.
     * So, if the default value is 5, if just hits return at the prompt, the
     * return value is 5. Otherwise, it's whatever the user typed in.
     *
     * @param prompt       The prompt to display.
     * @param defaultValue The default value to return if the user doesn't provide any input
     * @return The value entered (or default)
     */
    private int promptForInt(String prompt, int defaultValue) {
        System.out.printf(prompt + "[%s]: ", defaultValue);

        // do we have an int to read?
        if (scanner.hasNextInt()) {
            // read and return it (IE: not default)
            return scanner.nextInt();

        } else {
            // the user didn't input an int, so read the "bad" input.
            String badInput = scanner.next().trim();

            // was the input an empty string?
            if (badInput.equals("")) {
                // if so, return the default value
                return defaultValue;

            } else {
                // if not, try again
                return promptForInt(prompt, defaultValue);
            }
        }
    }

    /**
     * This method prompts the user to enter a string. If the prompt is not
     * required, then an empty string can be returned. If it IS required then an
     * empty string can not be provided.
     *
     * @param prompt   The prompt to display
     * @param required This indicates whether or not the prompt is required
     * @return The value the user input.
     */
    private String promptForString(String prompt, boolean required) {

        // show the prompt
        System.out.printf(prompt + ": ");

        // read the input (trimming whitespace)
        String input = scanner.next().trim();

        // Check if the field is required, but the length is 0
        if (required && input.length() == 0) {
            // there was no input to a required field.

            // show an error message
            System.out.println("\nThis field is required.\n");

            // try again
            return promptForString(prompt, required);

        } else {
            // return the value input
            return input;

        }
    }

    /**
     * Prompts for a string value, but specifies a default value.
     * So, if the default value is "cat", if the user just hits return at the
     * prompt, the return value is "cat". Otherwise, it's whatever the user
     * typed in.
     *
     * @param prompt       The prompt to display
     * @param defaultValue The default value
     * @return The value input (or the default)
     */
    private String promptForString(String prompt, String defaultValue) {

        System.out.printf(prompt + "[%s]: ", defaultValue);

        // read the next line (trimmed)
        String input = scanner.next().trim();

        // is the input an empty string?
        if (input.length() > 0) {
            // no, return the input that was provided
            return input;
        } else {
            // yes, return the default value
            return defaultValue;
        }
    }

    /**
     * This method prompts for the ID of a widget to display.
     *
     * @return The id of the widget to view
     */
    public int promptForWidgetToView() {
        return promptForWidgetTo("View");
    }

    /**
     * This method prompts for the ID of a widget to edit.
     *
     * @return The id of the widget to edit
     */
    public int promptForWidgetToEdit() {
        return promptForWidgetTo("Edit");
    }

    /**
     * This method prompts for the ID of a widget to delete.
     *
     * @return The id of the widget to delete
     */
    public int promptForWidgetToDelete() {
        return promptForWidgetTo("Delete");
    }

    /**
     * This private method is used by the other three "promptForWidgetToXYZ()"
     * methods. This one method accept an argument to change its prompts.
     *
     * @param action The action (delete, add, edit, view)
     * @return The integer the user provided
     */
    private int promptForWidgetTo(String action){
        System.out.printf("\n-- %s a Widget --\n", action);

        System.out.printf("\nPlease enter the number for the widget you wish to %s.\n\n", action.toLowerCase());

        // we're subtracting 1 from the widget ID because the printWidgetList() method above starts counting at 1, not 0.
        return promptForInt("Widget Id") - 1;
    }

    /**
     * This method prints out a detailed view of a widget.
     *
     * @param widget The Widget to display
     */
    public void displayWidget(Widget widget) {
        System.out.printf("\nName: %s\n", widget.name);
        System.out.printf("Description: %s\n", widget.description);
        System.out.printf("Type: %s\n", widget.type);
        System.out.printf("Weight: %s\n", widget.weight);
        System.out.printf("Inventory: %s\n", widget.inventory);
    }

    /**
     * This method prints an error message indicating that the specified widget
     * doesn't exist.
     *
     * @param id The ID for which a widget doesn't exist.
     */
    public void displayWidgetDoesNotExistError(int id) {
        // we're adding 1 to the id because the menu service's list starts counting at 1, not 0
        System.out.printf("\nWidget '%s' does not exist!\n", id + 1);
    }

    /**
     * This method updates an provided widget by prompting the user for updated
     * data. Each of the "promptForXYZ()" methods accepts a default, which is
     * the current value for the field in question. If the user doesn't enter a
     * new value and just hits enter, then the old value will be kept.
     *
     * Note that because objects are passed by-reference, we can update this
     * object here and the same reference will be updated in the ArrayList
     * contained within the WidgetService. (Note, this will note work in future
     * versions of this program.)
     *
     * @param widget The Widget to edit.
     */
    public void promptForWidgetEdits(Widget widget) {
        widget.name = promptForString("\nName", widget.name);
        widget.description = promptForString("Description", widget.description);
        widget.type = promptForString("Type", widget.type);
        widget.weight = promptForInt("Weight", widget.weight);
        widget.inventory = promptForInt("Inventory", widget.inventory);
    }

    /**
     * Prints a message indicating a widget was deleted.
     *
     * @param id The id of the Widget that was deleted
     */
    public void printWidgetDeleted(int id) {
        System.out.printf("\nWidget '%s' was deleted!\n", id + 1);
    }
}

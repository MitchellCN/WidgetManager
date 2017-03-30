package net.doughughes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by doug on 3/28/17.
 */
public class MenuService {

    Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptForMainMenu() {

        // print main menu with prompt
        System.out.println(
                "-- Main Menu --\n" +
                        "1) List Widgets\n" +
                        "2) Create a Widget\n" +
                        "3) View a Widget\n" +
                        "4) Edit a Widget\n" +
                        "5) Delete a Widget\n" +
                        "6) Quit\n\n" +
                        "Select an option: ");

        // check to see if we have an int
        if(scanner.hasNextInt()){
            // we have an int, read it
            int input = scanner.nextInt();

            // is the number in a valid range?
            if(input >= 1 && input <= 6){
                // return it!
                return input;
            } else {
                // nope, show an error and try again
                System.out.println("Error: '" + input + "' is not a valid choice!");

                return promptForMainMenu();
            }

        } else {
            // clear the buffer
            String badInput = scanner.nextLine();

            System.out.println("Error: '" + badInput + "' is not a valid number!");

            return promptForMainMenu();
        }

    }

    public Widget createWidget() {
        System.out.println("-- Create a Widget --");

        String name = promptForString("Name: ", true);
        String description = promptForString("Description: ", true);
        String type = promptForString("Type: ", false);

        System.out.println("Weight: ");
        double weight = scanner.nextDouble();

        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();

        return new Widget(name,
                description,
                type,
                weight,
                quantity);
    }


    public void displayWidgetList(ArrayList<Widget> widgets) {

        System.out.println("-- Widgets List --");

        if(widgets.size() == 0) {
            System.out.println("There are no widgets to display!");
        } else {
            int x = 1;
            for(Widget widget : widgets){
                System.out.printf("%s) %s\n", x, widget.getName());
                x++;
            }
        }
    }

    public void sayGoodbye() {

        System.out.println("Goodbye!");

    }

    protected String promptForString(String prompt, boolean required) {
        System.out.println(prompt);

        String input = scanner.nextLine().trim();

        // is the field required but empty?
        if(required && input.equals("")) {
            // show an error and re-prompt
            System.out.println("This field is required. Please try again.");
            return promptForString(prompt, required);

        } else if(input.length() == 0){
            // return null if it's not required and empty
            return null;

        } else {
            // return the value input
            return input;
        }
    }

    public int promptForInteger(String prompt) {
        System.out.println(prompt);

        if(!scanner.hasNextInt()){
            System.out.printf("'%s' is not a whole number. Please try again.", scanner.nextLine());

            return promptForInteger(prompt);
        } else {
            return scanner.nextInt();
        }

    }
}

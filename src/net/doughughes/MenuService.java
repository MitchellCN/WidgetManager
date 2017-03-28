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

    public void displayWidgetList(ArrayList<Widget> widgets) {

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
}

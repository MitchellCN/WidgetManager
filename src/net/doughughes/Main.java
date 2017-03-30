package net.doughughes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by doug on 3/29/17.
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Widget> widgets = new ArrayList<>();

    public static void main(String[] args) {

        MenuService menuService = new MenuService(scanner);

        while(true) {
            int selection = menuService.promptForMainMenu();

            if(selection == 1) {
                menuService.displayWidgetList(widgets);
            } else if(selection == 2){
                //menuService.createWidget();

            } else if(selection == 6) {
                menuService.sayGoodbye();
                // leave the loop, thereby quiting the program
                break;
            }
        }
    }
}

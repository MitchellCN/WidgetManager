package net.doughughes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by doug on 3/28/17.
 */
public class Main {
    public static void main(String[] args) {

        MenuService menu = new MenuService(new Scanner(System.in));
        ArrayList<Widget> widgets = new ArrayList<>();

        while(true){

            int choice = menu.promptForMainMenu();

            if(choice == 1){
                menu.displayWidgetList(widgets);
            }
        }

    }


}

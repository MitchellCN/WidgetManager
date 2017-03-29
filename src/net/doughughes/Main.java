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


        menuService.promptForMainMenu();
        menuService.displayWidgetList(widgets);
        menuService.sayGoodbye();
    }
}

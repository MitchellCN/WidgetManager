package com.theironyard;

import java.util.Scanner;

/**
 * Created by doug on 3/15/17.
 */
public class Main {
    public static void main(String[] args) {
        // create an instance of Scanner
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        // create our menuService
        MenuService menuService = new MenuService(scanner);

        // create our widgetService
        WidgetService widgetService = new WidgetService();

        // loop forever (or at least until the user quits)
        while(true){

            int action = menuService.promptForMainMenuSelection();

            if(action == MenuService.LIST_WIDGETS){

                // print out the list of widgets
                menuService.printWidgetList(widgetService.listWidgets());

            } else if(action == MenuService.CREATE_WIDGET) {

                // prompt the user for Widget data
                Widget widget = menuService.promptForNewWidget();

                // create the widget in our collection of widgets
                widgetService.createWidget(widget);

            } else if(action == MenuService.VIEW_WIDGET){

                // prompt the user for the widget they would like to view
                int id = menuService.promptForWidgetToView();

                try {
                    // try to read that widget
                    Widget widget = widgetService.getWidget(id);

                    // display the widget
                    menuService.displayWidget(widget);

                } catch(IndexOutOfBoundsException e){
                    // if we try to read a widget that doesn't exist we need to tell the user
                    menuService.displayWidgetDoesNotExistError(id);
                }

            } else if(action == MenuService.EDIT_WIDGET){
                // prompt the user for the widget they would like to edit
                int id = menuService.promptForWidgetToEdit();

                try {
                    // try to read that widget
                    Widget widget = widgetService.getWidget(id);

                    /*
                        This is a weird one. Note that our widgets are pointers
                        to instances of widgets in the WidgetService. Simply
                        updating a Widget in memory updates that widget wherever
                        it's referenced. This is why we don't need to save the
                        updated widget (in this version).
                     */
                    menuService.promptForWidgetEdits(widget);

                } catch(IndexOutOfBoundsException e){
                    // if we try to read a widget that doesn't exist we need to tell the user
                    menuService.displayWidgetDoesNotExistError(id);
                }

            } else if(action == MenuService.DELETE_WIDGET){
                // prompt the user for the widget they would like to delete
                int id = menuService.promptForWidgetToDelete();

                try {
                    // try to delete that widget
                    widgetService.deleteWidget(id);

                    // print that the widget was deleted
                    menuService.printWidgetDeleted(id);

                } catch(IndexOutOfBoundsException e){
                    // if we try to read a widget that doesn't exist we need to tell the user
                    menuService.displayWidgetDoesNotExistError(id);
                }
            } else if(action == MenuService.QUIT){
                // quit out of the loop
                break;
            }

        }
    }
}

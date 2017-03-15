package com.theironyard;

/**
 * Created by doug on 3/15/17.
 */
public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();

        while(true){

            int action = menuService.promptForMainMenuSelection();

            if(action == MenuService.LIST_WIDGETS){

            } else if(action == MenuService.CREATE_WIDGET) {

            } else if(action == MenuService.VIEW_WIDGET){

            } else if(action == MenuService.EDIT_WIDGET){

            } else if(action == MenuService.DELETE_WIDGET){

            } else if(action == MenuService.QUIT){
                // quit out of the loop
                break;
            }




        }
    }
}

package com.theironyard;

/**
 * Created by doug on 3/15/17.
 */
public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();

        while(true){

            int action = menuService.promptForMainMenuSelection();

            if(action == MenuService.LIST_ANIMALS){

            } else if(action == MenuService.CREATE_ANIMAL) {

            } else if(action == MenuService.VIEW_ANIMAL){

            } else if(action == MenuService.EDIT_ANIMAL){

            } else if(action == MenuService.DELETE_ANIMAL){

            } else if(action == MenuService.QUIT){
                // quit out of the loop
                break;
            }




        }
    }
}

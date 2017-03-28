package net.doughughes;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by doug on 3/28/17.
 */
public class MenuServiceTest {

    ByteArrayOutputStream outputStream;
    ArrayList<Widget> widgets;

    @Before
    public void before(){
        // setup output capturing
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(this.outputStream);
        System.setOut(printStream);


        widgets = new ArrayList<>();
        widgets.add(new Widget(
                "Roller Chain Guide",
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame",
                "Deep",
                1,
                12));
        widgets.add(new Widget(
                "Metric Ball Bearing Shim Ring",
                "for Bearing Number 38/608, 21.99mm Outside Diameter",
                "Shim",
                0.5,
                3)
        );
        widgets.add(new Widget(
                "Rigid Aluminum Conduit Fitting",
                "Reducing Bushing, 3/4 x 1/2 Trade Size",
                "Bushings",
                0.75,
                98
        ));
    }

    @Test
    /**
     * Given the main menu
     * When the user enters 1
     * Then 1 is returned
     */
    public void when1onMainMenuThen1(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(1));
    }

    @Test
    /**
     * Given the main menu
     * When the user enters 2
     * Then 2 is returned
     */
    public void when2onMainMenuThen2(){
        // Arrange
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(2));
    }

    @Test
    /**
     * Given the main menu
     * When the user enters 6
     * Then 6 is returned
     */
    public void when6onMainMenuThen6(){
        // Arrange
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);

        // Act
        int selection = menu.promptForMainMenu();

        // Assert
        assertThat(selection, equalTo(6));
    }

    @Test
    /**
     * When main menu prompt
     * Then the menu is displayed
     */
    public void whenMainMenuThenMenuPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("-- Main Menu --"));
    }

    @Test
    /**
     * When main menu displayed
     * Then menu includes "1) List Widgets"
     */
    public void whenMainMenuThenListWidgetsPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("1) List Widgets"));
    }

    @Test
    /**
     * When main menu displayed
     * Then menu includes "2) Create a Widget"
     */
    public void whenMainMenuThenCreateAWidgetPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("2) Create a Widget"));
    }

    @Test
    /**
     * When main menu displayed
     * Then menu includes "3) View a Widget"
     */
    public void whenMainMenuThenViewAWidgetPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("3) View a Widget"));
    }

    @Test
    /**
     * When main menu displayed
     * Then menu includes "4) Edit a Widget"
     */
    public void whenMainMenuThenEditAWidgetPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("4) Edit a Widget"));
    }

    @Test
    /**
     * When main menu displayed
     * Then menu includes "5) Delete a Widget"
     */
    public void whenMainMenuThenDeleteAWidgetPrinted(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("5) Delete a Widget"));
    }

    @Test
    /**
     * Given a main menu
     * When a string is input
     * Then I am re-prompted until an integer is entered
     */
    public void whenStringInputToMainMenuThenReprompt(){
        // Arrange
        Scanner scanner = new Scanner("Sandwich\nFoot\n5");
        MenuService menu = new MenuService(scanner);

        // Act
        int input = menu.promptForMainMenu();

        // Assert
        assertThat(input, equalTo(5));
    }

    @Test
    /**
     * When main menu displayed
     * Then a prompt for input is displayed
     */
    public void whenMainMenuThenPromptedForSelection(){
        // Arrange
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.promptForMainMenu();

        // Assert
        assertThat(this.outputStream.toString(), containsString("Select an option:"));
    }

    @Test
    /**
     * Given a main menu
     * When bad input provided
     * Then error message displayed
     */
    public void whenBadInputOnMainMenuThenErrorMessage(){
        // Arrange
        Scanner scanner = new Scanner("Sandwich\nFoot\n5");
        MenuService menu = new MenuService(scanner);

        // Act
        int input = menu.promptForMainMenu();

        // Assert
        assertThat(outputStream.toString(), containsString("Error: 'Sandwich' is not a valid number!"));
        assertThat(outputStream.toString(), containsString("Error: 'Foot' is not a valid number!"));

    }

    @Test
    /**
     * Given a main menu prompt
     * When a number outside of 1 to 6 is entered
     * Then an error message is printed
     */
    public void whenInvalidNumberEnteredOnMainMenuThenErrorMessagePrinted(){
        // Arrange
        Scanner scanner = new Scanner("7\n0\n-1\n3");
        MenuService menu = new MenuService(scanner);

        // Act
        int input = menu.promptForMainMenu();

        // Assert
        assertThat(outputStream.toString(), containsString("Error: '7' is not a valid choice!"));
        assertThat(outputStream.toString(), containsString("Error: '0' is not a valid choice!"));
        assertThat(outputStream.toString(), containsString("Error: '-1' is not a valid choice!"));

    }

    @Test
    /**
     * Given a list of NO widgets
     * When widgets are listed
     * Then no widgets are displayed
     */
    public void whenNoWidgetsThenNoWidgetMessageShown(){
        // Arrange
        Scanner scanner = new Scanner("");
        MenuService menu = new MenuService(scanner);

        ArrayList<Widget> widgets = new ArrayList<>();

        // Act
        menu.displayWidgetList(widgets);

        // Assert
        assertThat(outputStream.toString(), containsString("There are no widgets to display!"));
    }

    @Test
    /**
     * Given a list of three widgets
     * When widgets are listed
     * Then all three widgets are shown
     */
    public void whenWidgetsListedThenAllAreShown(){
        // Arrange
        Scanner scanner = new Scanner("");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.displayWidgetList(widgets);

        // Assert
        assertThat(outputStream.toString(), containsString("Roller Chain Guide"));
        assertThat(outputStream.toString(), containsString("Metric Ball Bearing Shim Ring"));
        assertThat(outputStream.toString(), containsString("Rigid Aluminum Conduit Fitting"));
    }

    @Test
    /**
     * Given a some widgets
     * When a list of widgets is printed
     * Then each widget gets an index number
     */
    public void whenWidgetsListedThenWidgetsHaveANumber(){
        // Arrange
        Scanner scanner = new Scanner("");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.displayWidgetList(widgets);

        // Assert
        assertThat(outputStream.toString(), containsString("1) Roller Chain Guide"));
        assertThat(outputStream.toString(), containsString("2) Metric Ball Bearing Shim Ring"));
        assertThat(outputStream.toString(), containsString("3) Rigid Aluminum Conduit Fitting"));
    }

}

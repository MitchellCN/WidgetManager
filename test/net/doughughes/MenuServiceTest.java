package net.doughughes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by doug on 3/28/17.
 */
public class MenuServiceTest extends IOTest{

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
        assertThat(outputStream.toString(), containsString("-- Main Menu --"));
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
        assertThat(outputStream.toString(), containsString("-- Widgets List --"));
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

    @Test
    /**
     * When creating a widget
     * Then correct prompts are displayed
     */
    public void whenCreatingWidgetThenPromptsDisplayed(){
        // Arrange
        Scanner scanner = new Scanner("Roller Chain Guide\n" +
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame\n" +
                "Deep\n" +
                "1\n" +
                "12\n");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.createWidget();

        // Assert

        // validate prompts
        assertThat(outputStream.toString(), containsString("-- Create a Widget --"));
        assertThat(outputStream.toString(), containsString("Name: "));
        assertThat(outputStream.toString(), containsString("Description: "));
        assertThat(outputStream.toString(), containsString("Type: "));
        assertThat(outputStream.toString(), containsString("Weight: "));
        assertThat(outputStream.toString(), containsString("Quantity: "));
    }

    @Test
    /**
     * When creating a widget
     * Then correct widget created
     */
    public void whenCreatingWidgetThenWidgetCreated(){
        // Arrange
        Scanner scanner = new Scanner("Roller Chain Guide\n" +
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame\n" +
                "Deep\n" +
                "1\n" +
                "12\n");
        MenuService menu = new MenuService(scanner);

        // Act
        Widget widget = menu.createWidget();

        // Assert

        // validate widget returned
        assertThat(widget.getName(), equalTo("Roller Chain Guide"));
        assertThat(widget.getDescription(), equalTo("Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame"));
        assertThat(widget.getType(), equalTo("Deep"));
        assertThat(widget.getWeight(), equalTo(1.0));
        assertThat(widget.getQuantity(), equalTo(12));
    }

    @Test
    /**
     * When creating a widget with no type
     * Then widget created with null type
     */
    public void whenCreatingWidgetWithNoTypeThenWidgetCreatedWithNullType(){
        // Arrange
        Scanner scanner = new Scanner("Roller Chain Guide\n" +
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame\n" +
                "\n" +
                "1\n" +
                "12\n");
        MenuService menu = new MenuService(scanner);

        // Act
        Widget widget = menu.createWidget();

        // Assert

        // validate widget returned
        assertThat(widget.getName(), equalTo("Roller Chain Guide"));
        assertThat(widget.getDescription(), equalTo("Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame"));
        assertThat(widget.getType(), nullValue());
        assertThat(widget.getWeight(), equalTo(1.0));
        assertThat(widget.getQuantity(), equalTo(12));
    }

    // todo: test missing name
    // todo: test missing description
    // todo: test non-numeric weight
    // todo: test non-numeric quantity

    @Test
    /**
     * Given a prompt for a required string
     * When input is empty
     * Then error shown and user re-prompted until valid data provided
     */
    public void whenPromptForRequiredStringThenStringIsRequired(){
        // Arrange
        Scanner scanner = new Scanner("\n" +
                "Foo Bar\n");
        MenuService menu = new MenuService(scanner);

        // Act
        String input = menu.promptForString("Required Prompt: ", true);

        // Assert
        assertThat(outputStream.toString(), containsString("Required Prompt: "));
        assertThat(outputStream.toString(), containsString("This field is required. Please try again."));
        assertThat(input, equalTo("Foo Bar"));
    }

    @Test
    /**
     * Given a prompt for an optional string
     * When input is empty
     * Then null is returned
     */
    public void whenPromptForOptionalStringThenEmptyStringReturnsNull(){
        // Arrange
        Scanner scanner = new Scanner("\n");
        MenuService menu = new MenuService(scanner);

        // Act
        String input = menu.promptForString("Optional Prompt: ", false);

        // Assert
        assertThat(outputStream.toString(), containsString("Optional Prompt: "));
        assertThat(input, nullValue());
    }


    @Test
    /**
     * Given a prompt for an optional string
     * When input is whitespace
     * Then null is returned
     */
    public void whenPromptForOptionalStringThenWhiteSpaceReturnsNull(){
        // Arrange
        Scanner scanner = new Scanner("      \n");
        MenuService menu = new MenuService(scanner);

        // Act
        String input = menu.promptForString("Whitespace Prompt: ", false);

        // Assert
        assertThat(outputStream.toString(), containsString("Whitespace Prompt: "));
        assertThat(input, nullValue());
    }

    @Test
    /**
     * Given a prompt for an integer
     * When input is not an integer
     * Then error shown and user re-prompted until valid data provided
     */
    public void whenPromptForIntegerThen123IsReturned(){
        // Arrange
        Scanner scanner = new Scanner("test\n" +
                "123\n");
        MenuService menu = new MenuService(scanner);

        // Act
        int input = menu.promptForInteger("Int Prompt: ");

        // Assert
        assertThat(outputStream.toString(), containsString("Int Prompt: "));
        assertThat(outputStream.toString(), containsString("'test' is not a whole number. Please try again."));
        assertThat(input, equalTo(123));
    }

    @Test
    /**
     * Given a prompt for an integer
     * When 321 is input
     * Then 321 is returned
     */
    public void whenPromptForIntegerThen321IsReturned(){
        // Arrange
        Scanner scanner = new Scanner("321\n");
        MenuService menu = new MenuService(scanner);

        // Act
        int input = menu.promptForInteger("Enter an int: ");

        // Assert
        assertThat(outputStream.toString(), containsString("Enter an int: "));
        assertThat(input, equalTo(321));
    }

    // todo: test integer prompt with empty string input


    @Test
    /**
     * When quitting
     * Then goodbye message printed
     */
    public void whenQuitThenGoodbye(){
        // Arrange
        Scanner scanner = new Scanner("");
        MenuService menu = new MenuService(scanner);

        // Act
        menu.sayGoodbye();

        // Assert
        assertThat(outputStream.toString(), containsString("Goodbye!"));
    }

}

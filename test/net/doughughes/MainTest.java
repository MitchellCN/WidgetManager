package net.doughughes;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This is an integration test that tests how the Main class functions.
 */
public class MainTest extends IOTest {

    @Test(timeout = 500)
    /**
     * Test listing widgets (when there are none).
     *
     * Script:
     *
     * 1) Start the program
     *  - User should see main menu
     *
     * 2) User enters 1 to list all widgets at the main menu
     *  - User should see a message saying there are no widgets to list
     *
     * 3) User enters 6 to quit the program
     *  - User should see message saying bye
     */
    public void testMenuThenListWidgetsWhenThereAreNone() {
        // Arrange
        Main.scanner = new Scanner("1\n6\n");

        // Act
        Main.main(null);

        // Assert

        // The program always starts with the main menu
        assertThat(outputStream.toString(), containsString("-- Main Menu --"));

        // user enters 1 to list widgets, we should see that title
        assertThat(outputStream.toString(), containsString("-- Widgets List --"));

        // for this test there are no widgets to display so the no-widgets message should be printed
        assertThat(outputStream.toString(), containsString("There are no widgets to display!"));

        // we should have then quit the application
        assertThat(outputStream.toString(), containsString("Goodbye!"));

    }

    @Test(timeout = 500)
    /**
     * Test listing widgets when there are some to show.
     *
     * Script:
     *
     * 1) Start the program
     *  - User should see main menu
     *
     * 2) User enters 1 to list all widgets at the main menu
     *  - User should see the set of widgets
     *
     * 3) User enters 6 to quit the program
     *  - User should see message saying bye
     */
    public void testMenuThenListWidgets() {
        // Arrange
        Main.scanner = new Scanner("1\n6\n");
        Main.widgets = widgets;

        // Act
        Main.main(null);

        // Assert

        // The program always starts with the main menu
        assertThat(outputStream.toString(), containsString("-- Main Menu --"));

        // user enters 1 to list widgets, we should see that title
        assertThat(outputStream.toString(), containsString("-- Widgets List --"));

        // for this test there are no widgets to display so the no-widgets message should be printed
        assertThat(outputStream.toString(), containsString("Roller Chain Guide"));
        assertThat(outputStream.toString(), containsString("Metric Ball Bearing Shim Ring"));
        assertThat(outputStream.toString(), containsString("Rigid Aluminum Conduit Fitting"));

        // we should have then quit the application
        assertThat(outputStream.toString(), containsString("Goodbye!"));
    }


    @Test
    /**
     * Test listing widgets, creating a widget, then listing the widgets again.
     *
     * Script:
     *
     * 1) Start the program
     *  - User should see main menu
     *
     * 2) User enters 1 to show empty list of widgets
     *  - User should see a message saying there are no widgets to list
     *
     * 3) User enters 2 to add a widget
     *  - Receives five prompts and enters data correctly
     *  - Sees success message
     *  - Sees main menu again
     *
     * 4) User enters 1 to show list of widgets
     *  - User should see new animal in the list
     *
     * This test demonstrates that the main class is looping appropriately and
     * that data is being persisted appropriately.
     */
    public void testEmptyListAddWidgetThenNonEmptyList() {
        // Arrange
        Main.scanner = new Scanner(
                // list
                "1\n" +
                        // add
                        "2\n" +
                        // provided prompted data
                        "Roller Chain Guide\n" +
                        "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame\n" +
                        "Deep\n" +
                        "1\n" +
                        "12\n" +
                        // list again
                        "2\n" +
                        // quit
                        "6\n"
        );

        // Act
        Main.main(null);

        // Assert

        /* Main menu */
        // The program always starts with the main menu
        assertThat(outputStream.toString(), containsString("-- Main Menu --"));


        /* List Widgets */
        // user enters 1 to list widgets, we should see that title
        assertThat(outputStream.toString(), containsString("-- Widgets List --"));

        // for this test there are no widgets to display so the no-widgets message should be printed
        assertThat(outputStream.toString(), containsString("There are no widgets to display!"));

        /* Add a widget */

        // should see add widget label
        assertThat(outputStream.toString(), containsString("-- Add Widget --"));

    }


    @After
    public void after() {
        // since the widgets is a static property we need to make sure we set it
        // to the default manually after each test.
        Main.widgets = new ArrayList<>();
    }

}

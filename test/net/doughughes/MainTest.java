package net.doughughes;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This is an integration test that tests how the Main class functions.
 */
public class MainTest {

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

        // since the widgets is a static property we need to make sure we set it to the default manually each time.
        Main.widgets = new ArrayList<>();
    }

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
    public void testMenuThenListWidgetsWhenThereAreNone(){
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
    public void testMenuThenListWidgets(){
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
}

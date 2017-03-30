package net.doughughes;

import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Generic base test to setup I/O capture as well as create a set of predictable
 * widgets.
 */
public class IOTest {
    ByteArrayOutputStream outputStream;
    ArrayList<Widget> widgets;

    @Before
    public void before() {
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
}

package net.doughughes;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by doug on 3/28/17.
 */
public class WidgetTest {

    @Test
    public void canInstantiateWidget(){
        // Arrange
        Widget widget = new Widget(
                "Roller Chain Guide",
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame",
                "Deep",
                1,
                12);

        // Assert
        assertThat(widget.getName(), equalTo("Roller Chain Guide"));
        assertThat(widget.getDescription(), equalTo("Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame"));
        assertThat(widget.getType(), equalTo("Deep"));
        assertThat(widget.getWeight(), equalTo(1.0));
        assertThat(widget.getQuantity(), equalTo(12));

    }

    @Test
    public void canInstantiateWidgetWithDoubleWeight(){
        // Arrange
        Widget widget = new Widget(
                "Roller Chain Guide",
                "Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame",
                "Deep",
                23.5,
                12);

        // Assert
        assertThat(widget.getName(), equalTo("Roller Chain Guide"));
        assertThat(widget.getDescription(), equalTo("Deep Channel for ANSI Number 40/2040, 304 Stainless Steel Frame"));
        assertThat(widget.getType(), equalTo("Deep"));
        assertThat(widget.getWeight(), equalTo(23.5));
        assertThat(widget.getQuantity(), equalTo(12));

    }


}

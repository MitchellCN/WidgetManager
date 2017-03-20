package com.theironyard;

import java.util.ArrayList;

/**
 * This class is used to manage widgets in our system. For version 1.0 this is
 * VERY simple. It's basically just an arrayList wrapped in a class. In future
 * versions this will become quite a bit more complex.
 *
 * You may be wondering why I don't just use the ArrayList directly. This is
 * because, as we add features to save this data to disk, we need to be able to
 * trigger this action when a method is invoked. If we use the ArrayList
 * directly in the Main class then we can't change the behavior of our system
 * without changing the Main class.
 */
public class WidgetService {

    /**
     * This is our data store. It holds the list of widgets we've entered into
     * our program.
     */
    private ArrayList<Widget> widgets = new ArrayList<>();

    /**
     * This method returns the list of Widgets in the system.
     * @return List of Widgets
     */
    public ArrayList<Widget> listWidgets() {
        return widgets;
    }

    /**
     * This method adds a widget to the list of widgets.
     * @param widget
     */
    public void createWidget(Widget widget) {
        widgets.add(widget);
    }

    /**
     * This method gets a specific widget by id.
     * @param id
     * @return
     */
    public Widget getWidget(int id) {
        // decrement the ID as
        return widgets.get(id);
    }

    /**
     * This method deletes a widget
     * @param id
     */
    public void deleteWidget(int id) {
        widgets.remove(id);
    }
}

package com.theironyard;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to manage widgets in our system
 */
public class WidgetService {

    private ArrayList<Widget> widgets = new ArrayList<>();

    public ArrayList<Widget> listWidgets() {
        return widgets;
    }

    public void createWidget(Widget widget) {
        widgets.add(widget);
    }

    public Widget getWidget(int id) {
        // decrement the ID as
        return widgets.get(id);
    }

    public void deleteWidget(int id) {
        widgets.remove(id);
    }
}

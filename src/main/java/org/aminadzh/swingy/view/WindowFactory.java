package org.aminadzh.swingy.view;

import org.aminadzh.swingy.controller.GameController;
import org.aminadzh.swingy.view.gui.GUIWindow;
import org.aminadzh.swingy.view.gui.GUIBoard;

import java.awt.*;

public class WindowFactory {

    public static Window createGUIWindow(String name, int width, int height, GUIBoard board, GameController controller) {
        return new GUIWindow(name, width, height, board, controller);
    }

}

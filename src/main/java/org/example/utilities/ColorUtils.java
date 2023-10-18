package org.example.utilities;

import java.awt.*;

import static java.awt.Color.WHITE;

public class ColorUtils {
    private ColorUtils() {
    }

    public static String getColoredText(String text, Color color) {
        return getColoredText(text, color, false, false);
    }

    public static String getColoredText(String text, Color color,
                                        boolean bold, boolean underlined) {
        StringBuilder cString = new StringBuilder("\u001B[");
        if (color == WHITE) {
            cString.append("30");
        } else if (color == Color.RED) {
            cString.append("31");
        } else if (color == Color.GREEN) {
            cString.append("32");
        } else if (color == Color.YELLOW) {
            cString.append("33");
        } else if (color == Color.BLUE) {
            cString.append("34");
        } else if (color == Color.MAGENTA) {
            cString.append("35");
        } else if (color == Color.CYAN) {
            cString.append("36");
        } else if (color == Color.GRAY) {
            cString.append("37");
        } else {
            cString.append("30");
        }
        if (bold) {
            cString.append(";1");
        }
        if (underlined) {
            cString.append(";4");
        }
        cString.append("m").append(text).append("\u001B[0m");
        return cString.toString();
    }

    public static String getBoldText(String text) {
        return getColoredText(text, WHITE, true, false);
    }

    public static String getBoldText(String text, Color color) {
        return getColoredText(text, color, true, true);
    }


}

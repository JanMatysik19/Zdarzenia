package Zadanie.App;

import java.awt.*;
import java.io.File;

public class AppInitials {
    public static GradientPaint APP_BG_GRADIENT(Dimension size) {
        return new GradientPaint(0, 0, Color.decode("#0a0a0a"), (float) size.getWidth(), (float) size.getHeight(), Color.decode("#400c0c"));
    }


    public static final Dimension BTN_SIZE = new Dimension(150, 25);


    public static final Color BTN_BG_COLOR = Color.decode("#ff5757");
    public static final Color BTN_DARK_BG_COLOR = Color.decode("#cd4949");


    public static final Color APP_BORDER_COLOR = Color.decode("#292929");


    public static final Color APP_SCROLL_THUMB_COLOR = Color.decode("#B1B1B1");


    public static final Color APP_CONTENT_COLOR = Color.decode("#1b1b1b");


    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);


    public static final int WINDOW_WIDTH = 700;
    public static final int WINDOW_HEIGHT = 500;

    public static final int WINDOW_RADIUS = 25;

    public static final String APP_TITLE = "Zdarzenia";


    public enum FONT_TYPE {
        PLAIN,
        BOLD,
        ITALIC
    }

    public static Font MONTSERRAT_FONT(FONT_TYPE type, float size) {
        int t = translateFont(type);

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File("./res/Montserrat-SemiBold.ttf")).deriveFont(t, size);
        } catch (Exception _) {
            System.exit(1);
            return null;
        }
    }

    public static Font ROBOTO_FONT(FONT_TYPE type, float size) {
        int t = translateFont(type);

        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File("./res/Roboto-Regular.ttf")).deriveFont(t, size);
        } catch (Exception _) {
            System.exit(1);
            return null;
        }
    }





    private static int translateFont(FONT_TYPE type) {
        return switch (type) {
            case BOLD -> Font.BOLD;
            case ITALIC -> Font.ITALIC;
            default -> Font.PLAIN;
        };
    }
}

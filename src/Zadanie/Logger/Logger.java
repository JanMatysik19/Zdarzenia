package Zadanie.Logger;

import Zadanie.App.AppInitials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Logger extends JTextArea {
    private final Map<Point, Integer> mouseLogger;
    private final Map<Character, Integer> keyboardLogger;


    public Logger() {
        mouseLogger = new HashMap<>();
        keyboardLogger = new HashMap<>();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addMouseClicked(e.getLocationOnScreen());
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                addKeyTyped(e.getKeyChar());
            }
        });

        setEditable(false);
        setOpaque(false);
        setBackground(AppInitials.TRANSPARENT);

        setFont(AppInitials.ROBOTO_FONT(AppInitials.FONT_TYPE.PLAIN, 12f));
        setForeground(Color.WHITE);

        setMargin(new Insets(20, 15, 20, 15));
    }



    public void addKeyTyped(char key) {
        if(keyboardLogger.containsKey(key)) {
            int tmp = keyboardLogger.get(key) + 1;
            keyboardLogger.put(key, tmp);
        } else {
            keyboardLogger.put(key, 1);
        }

        reloadDisplay();
    }


    public void addMouseClicked(Point loc) {
        if(mouseLogger.containsKey(loc)) {
            int tmp = mouseLogger.get(loc) + 1;
            mouseLogger.put(loc, tmp);
        } else {
            mouseLogger.put(loc, 1);
        }

        reloadDisplay();
    }


    public void reloadDisplay() {
        var sb = new StringBuilder();

        if(!keyboardLogger.isEmpty()) sb.append("Zdarzenia naciśniecia klawiszy na klawiaturze:\n");
        for(var entry : keyboardLogger.entrySet()) {
            String tmp = "     KLAWISZ: Wpisano: [" + entry.getKey() + "] (" + entry.getValue() + ")\n";
            sb.append(tmp);
        }

        if(!mouseLogger.isEmpty()) sb.append("Zdarzenia klinięcia myszą:\n");
        for(var entry : mouseLogger.entrySet()) {
            double x = entry.getKey().getX(),    y = entry.getKey().getY();
            String tmp = "     MYSZ: Kliknięcie w: [" + x + "], [" + y + "] (" + entry.getValue() + ")\n";
            sb.append(tmp);
        }

        setText(sb.toString());
    }


    public void resetLogs() {
        mouseLogger.clear();
        keyboardLogger.clear();

        reloadDisplay();

        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }
}

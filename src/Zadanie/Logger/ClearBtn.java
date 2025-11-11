package Zadanie.Logger;

import Zadanie.App.AppInitials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class ClearBtn extends JButton {
    private boolean hover;


    public ClearBtn() {
        setText("Wyczyść logi");
        setFont(AppInitials.ROBOTO_FONT(AppInitials.FONT_TYPE.BOLD, 14f));
        setForeground(Color.WHITE);

        setPreferredSize(AppInitials.BTN_SIZE);
        setMaximumSize(AppInitials.BTN_SIZE);

        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setBackground(AppInitials.TRANSPARENT);

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        hover = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                hover = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                hover = false;
            }
        });
    }



    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth(),     h = getHeight();
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(hover ? AppInitials.BTN_DARK_BG_COLOR : AppInitials.BTN_BG_COLOR);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, 20, 20));

        super.paintComponent(g);

        g2.dispose();
    }
}

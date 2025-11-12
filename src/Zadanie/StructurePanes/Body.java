package Zadanie.StructurePanes;

import Zadanie.App.AppInitials;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Body extends JPanel {


    public Body() {
        setLayout(new BorderLayout());
        setOpaque(false);
    }



    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth(),     h = getHeight();
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setClip(new RoundRectangle2D.Float(1, 1, w - 2, h - 2, AppInitials.WINDOW_RADIUS, AppInitials.WINDOW_RADIUS));

        g2.setPaint(AppInitials.APP_BG_GRADIENT(getSize()));
        g2.fillRect(0, 0, w, h);

        g2.setColor(AppInitials.APP_BORDER_COLOR);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(0, 0, w - 1, h - 1, AppInitials.WINDOW_RADIUS, AppInitials.WINDOW_RADIUS);

        g2.dispose();
    }


    @Override
    protected void paintChildren(Graphics g) {
        int w = getWidth(),     h = getHeight();
        var g2 = (Graphics2D) g.create();

        g2.setClip(new RoundRectangle2D.Float(1, 1, w - 2, h - 2, AppInitials.WINDOW_RADIUS, AppInitials.WINDOW_RADIUS));
        super.paintChildren(g2);

        g2.dispose();
    }
}

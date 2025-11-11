package Zadanie.Logger;

import Zadanie.App.AppInitials;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LoggerContainer extends JScrollPane {



    public LoggerContainer(Component component) {
        super(component);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        getVerticalScrollBar().setUI(new CustomScrollBarUI());
        getVerticalScrollBar().setOpaque(false);
        getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));


        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(null);
    }


    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth(),     h = getHeight();
        int r = 15;
        var g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setClip(new RoundRectangle2D.Float(0, 0, w, h, r, r));
        g2.setColor(AppInitials.APP_CONTENT_COLOR);
        g2.fillRect(0, 0, w, h);

        g2.setColor(AppInitials.APP_BORDER_COLOR);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(0, 0, w - 1, h - 1, r, r);

        super.paintComponent(g);

        g2.dispose();
    }



    static class CustomScrollBarUI extends BasicScrollBarUI {
        private final int width = 18;

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            var g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(AppInitials.APP_SCROLL_THUMB_COLOR);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);

            g2.dispose();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            var g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(AppInitials.APP_BORDER_COLOR);
            g2.fillRoundRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height, 10, 10);

            g2.dispose();
        }

        @Override
        protected Dimension getMaximumThumbSize() {
            return new Dimension(width, 100);
        }

        @Override
        protected Dimension getMinimumThumbSize() {
            return new Dimension(width, width);
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            return new Dimension(width, 0);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createEmptyButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createEmptyButton();
        }

        private JButton createEmptyButton() {
            var size = new Dimension(0, 0);

            var btn = new JButton();
            btn.setPreferredSize(size);
            btn.setMinimumSize(size);
            btn.setMaximumSize(size);

            return btn;
        }
    }
}

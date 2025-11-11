package Zadanie.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ToolBar extends JPanel {
    private final JFrame appFrame;
    private final Point clickPoint = new Point();
    private final CloseBtn closeBtn;


    public ToolBar(JFrame appFrame) {
        this.appFrame = appFrame;

        setOpaque(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(-1, 25));

        setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 2));

        addMouseListener(new BarClickHandler());
        addMouseMotionListener(new BarMouseMoveHandler());

        var eastButtons = new JPanel();
        eastButtons.setLayout(new BoxLayout(eastButtons, BoxLayout.X_AXIS));
        eastButtons.setOpaque(false);

        var minimizeBtn = new MinimizeBtn(appFrame);
        eastButtons.add(minimizeBtn);

        closeBtn = new CloseBtn();
        eastButtons.add(closeBtn);

        add(eastButtons, BorderLayout.EAST);
    }



    private class BarClickHandler extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            clickPoint.setLocation(e.getPoint());
        }
    }


    private class BarMouseMoveHandler extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            var currScreen = e.getLocationOnScreen();

            appFrame.setLocation((int) currScreen.getX() - clickPoint.x, (int) currScreen.getY() - clickPoint.y);
        }
    }


    public void setCloseBtnHandler(ActionListener l) {
        closeBtn.addActionListener(l);
    }
}

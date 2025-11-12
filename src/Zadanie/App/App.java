package Zadanie.App;

import Zadanie.StructurePanes.Body;
import Zadanie.StructurePanes.Main;
import Zadanie.ToolBar.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App extends JFrame {
    private Main main;
    private ToolBar toolBar;
    private Body content;


    public App() {
        content = new Body();
        setContentPane(content);


        toolBar = new ToolBar(this);
        toolBar.setCloseBtnHandler(e -> {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
        content.add(toolBar, BorderLayout.NORTH);

        main = new Main();
        content.add(main, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                var result = JOptionPane.showConfirmDialog(content, "Czy na pewno chcesz zakończyć działanie aplikacji?", "Zamykanie aplikacji", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(result == JOptionPane.YES_OPTION) dispose();
            }
        });

        setUndecorated(true);
        setBackground(AppInitials.TRANSPARENT);

        setBounds(200, 200, AppInitials.WINDOW_WIDTH, AppInitials.WINDOW_HEIGHT);
        setResizable(false);

        setTitle(AppInitials.APP_TITLE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}

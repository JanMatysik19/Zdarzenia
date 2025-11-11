package Cwiczenie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JLabel counterLbl;
    private JButton incrementerBtn;
    private Container content;
    private int count = 0;

    public App() {
        content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.add(Box.createRigidArea(new Dimension(0, 25)));

        counterLbl = new JLabel("Liczba kliknięć: " + getCount());
        counterLbl.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        content.add(counterLbl);

        content.add(Box.createRigidArea(new Dimension(0, 25)));

        incrementerBtn = new JButton("Inkrementuj");
        incrementerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                counterLbl.setText("Liczba kliknięć: " + getCount());
            }
        });
        incrementerBtn.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        content.add(incrementerBtn);

        content.add(Box.createRigidArea(new Dimension(0, 25)));

        setBounds(200, 200, 300, 150);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public int getCount() {
        return count;
    }


    public static void main(String[] args) {
        new App();
    }
}

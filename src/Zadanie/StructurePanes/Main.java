package Zadanie.StructurePanes;

import Zadanie.App.AppInitials;
import Zadanie.Logger.ClearBtn;
import Zadanie.Logger.Logger;
import Zadanie.Logger.LoggerContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel {
    private JLabel appTitleLbl;
    private JLabel logsLbl;
    private ClearBtn clearBtn;
    private Logger logger;
    private LoggerContainer loggerContainer;


    public Main() {
        appTitleLbl = new JLabel(AppInitials.APP_TITLE);
        appTitleLbl.setFont(AppInitials.MONTSERRAT_FONT(AppInitials.FONT_TYPE.BOLD, 24f));
        appTitleLbl.setForeground(Color.WHITE);

        logsLbl = new JLabel("Logi");
        logsLbl.setFont(AppInitials.MONTSERRAT_FONT(AppInitials.FONT_TYPE.PLAIN, 16f));
        logsLbl.setForeground(Color.WHITE);

        clearBtn = new ClearBtn();
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.resetLogs();
            }
        });

        logger = new Logger();
        loggerContainer = new LoggerContainer(logger);



        setLayout(new GridBagLayout());
        var c = new GridBagConstraints();
        c.weightx = 1;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 20, 0);
        add(appTitleLbl, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(0, 0, 20, 0);
        add(logsLbl, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(0, 0, 20, 0);
        add(clearBtn, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weighty = 1;
        c.anchor = GridBagConstraints.SOUTH;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0, 0, 0, 0);
        add(loggerContainer, c);


        SwingUtilities.invokeLater(() -> logger.requestFocusInWindow());

        setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));
        setOpaque(false);
    }
}

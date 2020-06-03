package project.main;
import project.gui.ManageClientFrame;
import project.gui.ManageSpectacolFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class MainGUI {
    private static JButton button;
    private static JFrame f;
    public static void main(String[] args) throws SQLException {
        //new ManageClientFrame("Adding client to data base");

        f = new JFrame("Main Menu");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(300, 300));
        f.getContentPane().setBackground(Color.darkGray);
        f.setLayout(null);

        JLabel title = new JLabel("Spectacole");
        title.setBounds(0,10,300,30);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.white);
        f.add(title);

        button = new JButton("Client Menu");
        button.setBounds(75, 60, 150, 30);
        button.addActionListener(event -> {
            try {
                openClientMenu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        f.add(button);

        button = new JButton("Spectacol Menu");
        button.setBounds(75, 100, 150, 30);
        button.addActionListener(event -> {
            try {
                openSpectacolMenu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        f.add(button);


        button = new JButton("Quit");
        button.setBounds(100, 200, 100, 30);
        button.addActionListener(event -> quit());
        f.add(button);

        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.pack();
    }

    public static void openClientMenu() throws SQLException {
        new ManageClientFrame(f);
        f.setVisible(false);
    }

    public static void openSpectacolMenu() throws SQLException {
        new ManageSpectacolFrame(f);
        f.setVisible(false);
    }

    private static void quit()
    {
        f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
    }
}
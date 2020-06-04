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

        f = new JFrame("Meniu Principal");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setMinimumSize(new Dimension(500, 500));
        f.getContentPane().setBackground(Color.lightGray);
        f.setLayout(null);

        button = new JButton("Meniu Client");
        button.setBounds(150, 90, 200, 50);
        button.addActionListener(event -> {
            try {
                openClientMenu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        f.add(button);

        button = new JButton("Meniu Spectacol");
        button.setBounds(150, 160, 200, 50);
        button.addActionListener(event -> {
            try {
                openSpectacolMenu();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        f.add(button);


        button = new JButton("Iesire");
        button.setBounds(150, 260, 200, 50);
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
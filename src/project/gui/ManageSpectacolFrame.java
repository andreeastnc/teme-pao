package project.gui;

import project.model.Client;
import project.model.Spectacol;
import project.repository.BDConnection;
import project.repository.BDRepositorySpectacol;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ManageSpectacolFrame extends JFrame {

    private Connection connection = BDConnection.getBDConnection();
    private BDRepositorySpectacol repository = new BDRepositorySpectacol(connection);

    public ManageSpectacolFrame(JFrame title) throws SQLException {
        super(String.valueOf(title));

        JLabel nameLabel = new JLabel("Nume: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(0, 50, 200, 30);
        name.setBounds(60, 50, 200, 30);

        JLabel priceLabel = new JLabel("Pret: " );
        JTextField pret = new JTextField();
        nameLabel.setBounds(0, 50, 200, 30);
        name.setBounds(80, 60, 200, 30);

        JLabel nrLocuriLabel = new JLabel("Numar locuri: " );
        JTextField numarLocuri = new JTextField();
        nameLabel.setBounds(0, 50, 200, 30);
        name.setBounds(100, 80, 200, 30);

        JButton button = new JButton("Adauga spectacol: ");
        button.setBounds(120, 190, 150, 30);
        button.addActionListener(event -> {
            try {
                addSpectacolBD(name, pret, numarLocuri);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        JLabel listLabel = new JLabel("Lista tuturor spectacolelor: ");
        listLabel.setHorizontalAlignment(JLabel.CENTER);
        listLabel.setForeground(Color.blue);
        listLabel.setBounds(0, 200, 200, 20);

        JList<Spectacol> spectacolJList = new JList<>();
        spectacolJList.setBounds(0, 240, 400, 200);
        spectacolJList.setListData(getSpectacole());

        add(name);
        add(nameLabel);
        add(pret);
        add(priceLabel);
        add(numarLocuri);
        add(nrLocuriLabel);
        add(button);
        add(listLabel);
        add(spectacolJList);

        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void addSpectacolBD(JTextField name, JTextField pret, JTextField numarLocuri) throws SQLException {
        String n1 = name.getText();
        int n2 = Integer.parseInt(pret.getText());
        int n3 = Integer.parseInt(numarLocuri.getText());
        Spectacol spectacol = new Spectacol(n1,n2,n3);
        this.repository.add(spectacol);
        JOptionPane.showMessageDialog(this, "Clientul a fost adaugat cu succes!");

    }

    public Spectacol[] getSpectacole() throws SQLException {
        return repository.getSpectacole().toArray(new Spectacol[0]);
    }
}

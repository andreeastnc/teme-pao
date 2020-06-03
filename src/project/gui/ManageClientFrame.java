package gui;

import project.model.Client;
import project.repository.BDConnection;
import project.repository.BDRepositoryClient;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ManageClientFrame extends JFrame {

    private Connection connection = BDConnection.getBDConnection();
    private BDRepositoryClient repository = new BDRepositoryClient(connection);

    public ManageClientFrame(String title) throws SQLException {
        super(title);

        JLabel nameLabel = new JLabel("Nume: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(0, 50, 200, 30);
        name.setBounds(60, 50, 200, 30);

        JButton button = new JButton("Adauga client: ");
        button.setBounds(80, 150, 150, 30);
        button.addActionListener(event -> {
            try {
                addClientDB(name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        JLabel listLabel = new JLabel("Lista tuturor clientilor: ");
        listLabel.setHorizontalAlignment(JLabel.CENTER);
        listLabel.setForeground(Color.blue);
        listLabel.setBounds(0, 200, 200, 20);

        JList<Client> clientJList = new JList<>();
        clientJList.setBounds(0, 240, 400, 200);
        clientJList.setListData(getClienti());

        add(name);
        add(nameLabel);
        add(button);
        add(listLabel);
        add(clientJList);

        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    public void addClientDB(JTextField name) throws SQLException {
        String n1 = name.getText();
        Client client = new Client(n1);
        this.repository.add(client);
        JOptionPane.showMessageDialog(this, "Clientul a fost adaugat cu succes!");

    }

    public Client[] getClienti() throws SQLException {
        return repository.getClienti().toArray(new Client[0]);
    }
}

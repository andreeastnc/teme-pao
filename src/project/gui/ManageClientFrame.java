package project.gui;

import project.model.Client;
import project.repository.BDConnection;
import project.repository.BDRepositoryClient;
import project.service.BDBiletService;
import project.service.BDClientService;
import project.service.ServiceClient;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ManageClientFrame extends JFrame {
    private Connection connection = BDConnection.getBDConnection();
    private BDRepositoryClient repository = new BDRepositoryClient(connection);
    BDClientService serviceClient = BDClientService.getInstanta();

    public ManageClientFrame(JFrame title) throws SQLException {
        super(String.valueOf(title));

        JLabel nameLabel = new JLabel("Nume: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(0, 50, 200, 30);
        name.setBounds(60, 50, 200, 30);


        Scanner s = new Scanner(System.in);
        JButton button = new JButton("Adauga client: ");
        button.setBounds(80, 150, 150, 30);
        button.addActionListener(event -> serviceClient.addClient(s));

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

    public Client[] getClienti() throws SQLException {
        return repository.getClienti().toArray(new Client[0]);
    }
}

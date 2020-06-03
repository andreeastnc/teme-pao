package project.repository;
import project.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDRepositoryClient {
    private Connection connection = null;
    public BDRepositoryClient() {}

    public BDRepositoryClient(Connection connection) {
        this.connection = connection;
    }

    public void add(Client client) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlAdd;
        sqlAdd = "INSERT INTO client VALUES (?)";

        PreparedStatement statement =  connection.prepareStatement(sqlAdd);
        statement.setString(1, client.getNumeClient());
        //statement.setInt(2, client.getTipClient());

        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
    }

    public Boolean stergeClient(String nume) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlDelete = "DELETE FROM client WHERE nume_client = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlDelete);
        statement.setString(1, nume);
        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
        return true;
    }

    public Client getClientByNume(String name) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sql = "SELECT * FROM client WHERE nume_client = ?";

        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next())
        {
            BDConnection.closeBDConnection(connection);
            return new Client(resultSet.getString(1));
        }
        BDConnection.closeBDConnection(connection);
        return null;
    }

    public void changeNume(String nou, String old) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlUpdate = "UPDATE client SET name = ? WHERE name = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setString(1, nou);
        statement.setString(2, old);
        statement.executeUpdate();
    }

    public ArrayList<Client> getClienti() throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        ArrayList<Client> clienti = new ArrayList<>();

        String sqlSelect = "SELECT * FROM client";
        PreparedStatement statement =  connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())    {
            Client client = new Client(resultSet.getString(1));
            clienti.add(client);
        }
        BDConnection.closeBDConnection(connection);
        return clienti;
    }
}

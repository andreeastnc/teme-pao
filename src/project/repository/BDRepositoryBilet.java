package project.repository;


import project.model.Bilet;
import project.model.Client;
import project.model.Loc;
import project.model.Spectacol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BDRepositoryBilet {
    public BDRepositoryBilet() {}

    public void add(Bilet bilet, Spectacol spectacol, Client client) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlAdd;
        sqlAdd = "INSERT INTO bilet VALUES (?,?)";

        PreparedStatement statement =  connection.prepareStatement(sqlAdd);
        statement.setString(1, spectacol.getNumeSpectacol());
        statement.setString(2, client.getNumeClient());

        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
    }

    public Boolean stergeBilet(String nume) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlDelete = "DELETE FROM bilet WHERE nume_spectacol = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlDelete);
        statement.setString(1, nume);
        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
        return true;
    }

    public Bilet getBiletByNumeSpectacol(String name) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sql = "SELECT * FROM bilet WHERE nume_spectacol = ?";

        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        String sqlSelectSpectacol = "SELECT * FROM spectacol";
        PreparedStatement statementSpectacol =  connection.prepareStatement(sqlSelectSpectacol);
        ResultSet resultSetSpectacol = statementSpectacol.executeQuery();
        if(resultSet.next())
        {
            BDConnection.closeBDConnection(connection);
            Spectacol spectacol = new Spectacol(resultSetSpectacol.getString(1),resultSetSpectacol.getInt(3),resultSetSpectacol.getInt(2));
            Loc loc = new Loc(5);
            Client client = new Client(resultSet.getString(2));
            return new Bilet(spectacol, loc, client);
        }
        BDConnection.closeBDConnection(connection);
        return null;
    }

    public ArrayList<Bilet> getBilete() throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        ArrayList<Bilet> bilete = new ArrayList<>();

        String sqlSelect = "SELECT * FROM bilet";
        PreparedStatement statement =  connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();
        String sqlSelectSpectacol = "SELECT * FROM spectacol";
        PreparedStatement statementSpectacol =  connection.prepareStatement(sqlSelectSpectacol);
        ResultSet resultSetSpectacol = statementSpectacol.executeQuery();
        while (resultSet.next() && resultSetSpectacol.next()) {
            Spectacol spectacol = new Spectacol(resultSetSpectacol.getString(1),resultSetSpectacol.getInt(3),resultSetSpectacol.getInt(2));
            Loc loc = new Loc(5);
            Client client = new Client(resultSet.getString(2));
            Bilet bilet = new Bilet(spectacol, loc, client);
            bilete.add(bilet);
        }
        BDConnection.closeBDConnection(connection);
        return bilete;
    }
}

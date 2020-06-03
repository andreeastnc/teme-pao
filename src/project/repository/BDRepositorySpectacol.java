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

public class BDRepositorySpectacol {
    private Connection connection = null;
    public BDRepositorySpectacol() {}
    public BDRepositorySpectacol(Connection connection) {
        this.connection = connection;
    }

    public void add(Spectacol spectacol) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlAdd;
        sqlAdd = "INSERT INTO spectacol VALUES (?,?,?)";

        PreparedStatement statement =  connection.prepareStatement(sqlAdd);
        statement.setString(1, spectacol.getNumeSpectacol());
        statement.setInt(2, spectacol.getPret());
        statement.setInt(2, spectacol.getNumarLocuri());

        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
    }

    public Boolean stergeSpectacol(String nume) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sqlDelete = "DELETE FROM spectacol WHERE nume_spectacol = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlDelete);
        statement.setString(1, nume);
        statement.executeUpdate();
        BDConnection.closeBDConnection(connection);
        return true;
    }

    public Spectacol getSpectacolByNumeSpectacol(String name) throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        String sql = "SELECT * FROM spectacol WHERE nume_spectacol = ?";

        PreparedStatement statement =  connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next())
        {
            BDConnection.closeBDConnection(connection);
            return new Spectacol(resultSet.getString(1),resultSet.getInt(2),resultSet.getInt(3));
        }
        BDConnection.closeBDConnection(connection);
        return null;
    }

    public ArrayList<Spectacol> getSpectacole() throws SQLException {
        Connection connection = BDConnection.getBDConnection();
        ArrayList<Spectacol> spectacole = new ArrayList<>();

        String sqlSelect = "SELECT * FROM spectacol";
        PreparedStatement statement =  connection.prepareStatement(sqlSelect);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Spectacol spectacol = new Spectacol(resultSet.getString(1),resultSet.getInt(3),resultSet.getInt(2));
            spectacole.add(spectacol);
        }
        BDConnection.closeBDConnection(connection);
        return spectacole;
    }
}

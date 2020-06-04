package project.service;

import project.model.Client;
import project.repository.BDRepositoryClient;
import project.repository.RepositoryClient;

import java.sql.SQLException;
import java.util.Scanner;

public class BDClientService {
    private BDRepositoryClient repositoryClient = new BDRepositoryClient();
    private AuditService auditService;
    private static BDClientService instanta = new BDClientService();

    public static BDClientService getInstanta() {
        return instanta;
    }

    public BDClientService()
    {
        repositoryClient = new BDRepositoryClient();
        auditService = AuditService.getInstanta();
    }

    public Client addClient(Scanner s)
    {
        System.out.println("Nume client: ");
        String nume= s.next();

        Client client = new Client(nume);
        try {
            repositoryClient.add(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Adaugare client nou", auditService.getTimestamp());
        return client;
    }

    public void removeClient(Scanner s)
    {
        System.out.println("Scrie numele clientului:");
        try {
            if(repositoryClient.stergeClient(s.next()))
                System.out.println("Client sters!");
            else
                System.out.println("Clientul nu a fost sters!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("A fost sters un client", auditService.getTimestamp());
    }

    public Client getClientByNume(String nume)
    {
        auditService.actiune("Luare client dupa nume", auditService.getTimestamp());
        try {
            return repositoryClient.getClientByNume(nume);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String allClienti()
    {
        StringBuilder res = new StringBuilder();
        try {
            for(Client client : repositoryClient.getClienti())
            {
                res.append(client.toString()).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Au fost luati toti clientii", auditService.getTimestamp());
        return res.toString();
    }

    private BDRepositoryClient getRepositoryClient() {
        return repositoryClient;
    }
}

package project.service;

import project.model.Bilet;
import project.model.Client;
import project.model.Loc;
import project.model.Spectacol;
import project.repository.BDRepositoryBilet;
import project.repository.BDRepositoryClient;

import java.sql.SQLException;
import java.util.Scanner;

public class BDBiletService {
    private BDRepositoryBilet repositoryBilet;
    private AuditService auditService;

    public BDBiletService()
    {
        repositoryBilet = new BDRepositoryBilet();
        auditService = AuditService.getInstanta();
    }

    public Bilet addBilet(Scanner s)
    {
        System.out.println("Nume spectacol: ");
        String nume= s.next();
        int numarLocuri = Integer.parseInt(s.next());
        int pretBilet = Integer.parseInt(s.next());
        Spectacol spectacol = new Spectacol(nume, pretBilet, numarLocuri);
        Loc loc = new Loc(5);
        String numeClient = s.next();
        Client client = new Client(numeClient);
        Bilet bilet = new Bilet(spectacol, loc, client);
        try {
            repositoryBilet.add(bilet, spectacol, client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Adaugare bilet nou", auditService.getTimestamp());
        return bilet;
    }

    public void removeBilet(Scanner s)
    {
        System.out.println("Scrie numele spectacolului:");
        try {
            if(repositoryBilet.stergeBilet(s.next()))
                System.out.println("Bilet sters!");
            else
                System.out.println("Biletul nu a fost sters!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("A fost sters un bilet", auditService.getTimestamp());
    }

    public Bilet getBiletByNumeSpectacol(String nume)
    {
        auditService.actiune("Luare bilet dupa nume", auditService.getTimestamp());
        try {
            return repositoryBilet.getBiletByNumeSpectacol(nume);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String allBilete()
    {
        StringBuilder res = new StringBuilder();
        try {
            for(Bilet bilet : repositoryBilet.getBilete())
            {
                res.append(bilet.toString()).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Au fost luate toate biletele", auditService.getTimestamp());
        return res.toString();
    }

    private BDRepositoryBilet getRepositoryBilet() {
        return repositoryBilet;
    }
}

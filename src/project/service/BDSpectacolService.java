package project.service;

import project.model.Spectacol;
import project.repository.BDRepositorySpectacol;

import java.sql.SQLException;
import java.util.Scanner;

public class BDSpectacolService {
    private BDRepositorySpectacol repositorySpectacol;
    private AuditService auditService;

    public BDSpectacolService()
    {
        repositorySpectacol = new BDRepositorySpectacol();
        auditService = AuditService.getInstanta();
    }

    public Spectacol addSpectacol(Scanner s)
    {
        System.out.println("Nume spectacol: ");
        String nume = s.next();
        int pret = Integer.parseInt(s.next());
        int numarLocuri = Integer.parseInt(s.next());

        Spectacol spectacol = new Spectacol(nume, pret, numarLocuri);
        try {
            repositorySpectacol.add(spectacol);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Adaugare spectacol nou", auditService.getTimestamp());
        return spectacol;
    }

    public void removeSpectacol(Scanner s)
    {
        System.out.println("Scrie numele spectacolului:");
        try {
            if(repositorySpectacol.stergeSpectacol(s.next()))
                System.out.println("Spectacol sters!");
            else
                System.out.println("Spectacolul nu a fost sters!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("A fost sters un spectacol", auditService.getTimestamp());
    }

    public Spectacol getSpectacolByNume(String nume)
    {
        auditService.actiune("Luare spectacol dupa nume", auditService.getTimestamp());
        try {
            return repositorySpectacol.getSpectacolByNumeSpectacol(nume);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String allSpectacole()
    {
        StringBuilder res = new StringBuilder();
        try {
            for(Spectacol spectacol : repositorySpectacol.getSpectacole())
            {
                res.append(spectacol.toString()).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        auditService.actiune("Au fost luate toate spectacolele", auditService.getTimestamp());
        return res.toString();
    }

    private BDRepositorySpectacol getRepositorySpectacol() {
        return repositorySpectacol;
    }
}

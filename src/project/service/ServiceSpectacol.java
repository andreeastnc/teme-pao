package project.service;

import project.model.Client;
import project.model.Spectacol;
import project.repository.RepositorySpectacol;

import java.util.ArrayList;

public class ServiceSpectacol {
    private RepositorySpectacol repositorySpectacol = new RepositorySpectacol();
    private static ServiceSpectacol instanta = new ServiceSpectacol();
    FileWritingSpectacol fileWritingSpectacol = FileWritingSpectacol.getInstantaScriere();
    AuditService auditService = AuditService.getInstanta();

    private ServiceSpectacol() { }

    public static ServiceSpectacol getInstanta() {
        return instanta;
    }

    public void addSpectacol(Spectacol spectacol) {
        repositorySpectacol.add(spectacol);
    }

    public Spectacol getSpectacolById(int idSpectacol) {
        return repositorySpectacol.getSpectacolById(idSpectacol);
    }

    public Spectacol getSpectacolByPret(int pret) {
        return repositorySpectacol.getSpectacolByPret(pret);
    }

    public ArrayList<Spectacol> getAllSpectacole() {
        return repositorySpectacol.getAll();
    }

    public void schimbarePretBiletBySpectacolId(int idSpectacol, int pret) {
        Spectacol spectacol = repositorySpectacol.getSpectacolById(idSpectacol);
        if(spectacol == null) {
            System.out.println("Acest spectacol nu exista.");
        } else {
            spectacol.setPret(pret);
        }
    }

    public void showSpectacol(Spectacol spectacol) {
        repositorySpectacol.showSpectacol(spectacol);
    }


    public void addExistingShow(Spectacol spectacol) {
        auditService.actiune("Adaugare spectacol din fisier", auditService.getTimestamp());
        repositorySpectacol.add(spectacol);
    }

    public void getSpectacoleDinFisier() {
        auditService.actiune("Ia toate spectacolele din fisier", auditService.getTimestamp());
        FileReadingSpectacol fileReadingSpectacol = FileReadingSpectacol.getReadingInstanta();
        ArrayList<Spectacol> spectacole = fileReadingSpectacol.citireSpectacole();
        for(Spectacol spectacol : spectacole) {
            addExistingShow(spectacol);
        }
    }

}
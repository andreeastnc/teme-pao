package project.service;

import project.model.*;
import project.repository.RepositoryBilet;

import java.util.ArrayList;

public class ServiceBilet {
    private RepositoryBilet repositoryBilet = new RepositoryBilet();
    private static ServiceBilet instanta = new ServiceBilet();

    private ServiceBilet() { }

    public static ServiceBilet getInstanta() {
        return instanta;
    }

    public void showBilet(Bilet bilet) {
        repositoryBilet.showBilet(bilet);
    }


    public boolean verificareDisponibilitateBilet(Bilet bilet) {
        int numar = bilet.getLoc().getNumarLoc();
        if(numar < bilet.getSpectacol().getNumarLocuri()) {
            return bilet.getSpectacol().verificareLoc(numar);
        }
        return false;
    }

    public void addBilet(Bilet bilet) {
        if (verificareDisponibilitateBilet(bilet)) {
            bilet.getSpectacol().getLocLiber();
            repositoryBilet.add(bilet);
        } else {
            System.out.println("Locul este ocupat.");
        }
    }

    public Bilet getBiletByNumarBilet(int numarBilet) {
        return repositoryBilet.getBiletByNumarBilet(numarBilet);
    }

    public ArrayList<Bilet> getBiletByNumarClient(int numarClient) {
        return repositoryBilet.getAllByNumarClient(numarClient);
    }

    public ArrayList<Bilet> getAllBilete() {
        return repositoryBilet.getAll();
    }

    public void anulareBilet(int numarBilet) {
        Bilet bilet = repositoryBilet.getBiletByNumarBilet(numarBilet);
        if(bilet == null) {
            System.out.println("Nu exista acest bilet.");
        }
        Loc loc = bilet.getLoc();
        bilet.getSpectacol().setLoc(loc.getNumarLoc(), true);
        repositoryBilet.stergere(bilet);
    }

    public double getCastiguriSpectacolByIdSpectacol(int idSpectacol) {
        ServiceSpectacol serviceSpectacol = ServiceSpectacol.getInstanta();
        Spectacol spectacol = serviceSpectacol.getSpectacolById(idSpectacol);
        double castiguri = 0.0;
        ArrayList<Bilet> bilete = repositoryBilet.getAllByIdSpectacol(spectacol.getIdSpectacol());
        for(Bilet bilet : bilete) {
            castiguri += bilet.getClient().getPret(spectacol.getPret());
        }
        return castiguri;
    }
}
package project.repository;

import project.model.Client;
import project.model.Spectacol;

import java.util.ArrayList;
import java.util.Date;

public class RepositorySpectacol {
    private ArrayList<Spectacol> bdSpectacol;

    public RepositorySpectacol() {
        bdSpectacol = new ArrayList<>();
    }

    public void add(Spectacol spectacol) {
        bdSpectacol.add(spectacol);
    }

    public Spectacol getSpectacolById(int idSpectacol) {
        for(Spectacol spectacol : bdSpectacol) {
            if(spectacol.getIdSpectacol() == idSpectacol) {
                return spectacol;
            }
        }
        return null;
    }

    public Spectacol getSpectacolByPret(int pret) {
        for(Spectacol spectacol : bdSpectacol) {
            if(spectacol.getIdSpectacol() == pret) {
                return spectacol;
            }
        }
        return null;
    }

    public ArrayList<Spectacol> getAll() {
        return bdSpectacol;
    }

    public void showSpectacol(Spectacol spectacol) {
        spectacol.show();
    }
}

package project.repository;
import project.model.Bilet;
import project.model.Client;

import java.util.ArrayList;

public class RepositoryBilet {
    private ArrayList<Bilet> bdBilet;

    public RepositoryBilet() {
        bdBilet = new ArrayList<>();
    }

    public void add(Bilet bilet) {
        bdBilet.add(bilet);
    }

    public Bilet getBiletByNumarBilet(int numarBilet) {
        for(Bilet bilet : bdBilet) {
            if(bilet.getNumarBilet() == numarBilet) {
                return bilet;
            }
        }
        return null;
    }

    public ArrayList<Bilet> getAllByNumarClient(int numarClient) {
        ArrayList<Bilet> bilete = new ArrayList<>();
        for(Bilet bilet : bdBilet) {
            if(bilet.getClient().getNumarClient() == numarClient){
                bilete.add(bilet);
            }
        }
        return bilete;
    }

    public ArrayList<Bilet> getAllByIdSpectacol(int idSpectacol) {
        ArrayList<Bilet> bilete = new ArrayList<>();

        for(Bilet bilet : bdBilet) {
            if(bilet.getSpectacol().getIdSpectacol() == idSpectacol){
                bilete.add(bilet);
            }
        }
        return bilete;
    }


    public ArrayList<Bilet> getAll() {
        return bdBilet;
    }

    public void stergere(Bilet bilet) {
        bdBilet.remove(bilet);
    }

    public void showBilet(Bilet bilet) {
        bilet.show();
    }
}

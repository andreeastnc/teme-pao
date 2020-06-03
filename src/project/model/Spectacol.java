package project.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Spectacol {
    private static int id = 0;
    private int idSpectacol;
    private String numeSpectacol;
    private int pret;
    private int numarLocuri;
    private boolean []loc = null;

    public Spectacol(String numeSpectacol, int pret, int numarLocuri) {
        this.numeSpectacol = numeSpectacol;
        this.pret = pret;
        this.numarLocuri = numarLocuri;
        this.loc = new boolean[numarLocuri];
        for(int i = 0; i < numarLocuri; i++) {
            loc[i] = false;
        }
        this.idSpectacol = ++id;
    }

    public Spectacol(String string) {
        this.numeSpectacol = numeSpectacol;
    }

    public int getPret() {
        return pret;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public String getNumeSpectacol() {
        return numeSpectacol;
    }

    public int getIdSpectacol() {
        return idSpectacol;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public boolean verificareLoc(int numarLoc) {
        return !loc[numarLoc];
    }

    public Loc getLocLiber() {
        for(int i = 0; i < getNumarLocuri(); i++) {
            if (!loc[i]) {
                loc[i] = true;
                Loc loc = new Loc(i);
                return loc;
            }
        }
        return null;
    }

    public void setNumeSpectacol(String numeSpectacol) {
        this.numeSpectacol = numeSpectacol;
    }

    public void setLoc(int numarLoc, boolean tip) {
        this.loc[numarLoc] = tip;
    }

    public void show() {
        System.out.println("Spectacol " + getIdSpectacol() + ": " + getNumeSpectacol() + ", pret: " + getPret() + "ron");
    }
}

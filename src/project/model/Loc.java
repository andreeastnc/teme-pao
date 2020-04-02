package project.model;

public class Loc {
    private int numarLoc;

    public Loc(int numarLoc) {
        this.numarLoc = numarLoc;
    }

    public int getNumarLoc() {
        return numarLoc;
    }

    public void setLoc(int numarLoc) {
        this.numarLoc = numarLoc;
    }

    public void show() {
        System.out.println("Loc: " + getNumarLoc());
    }
}

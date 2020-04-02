package project.model;

public class Bilet {
    private  static int numar = 0;
    private int numarBilet;
    private Spectacol spectacol;
    private Client client;
    private Loc loc;

    public Bilet(Spectacol spectacol, Loc loc, Client client) {
        this.client = client;
        this.spectacol = spectacol;
        this.loc = loc;
        this.numarBilet = ++numar;
    }

    public int getNumarBilet() {
        return numarBilet;
    }

    public Client getClient() {
        return client;
    }

    public Spectacol getSpectacol() {
        return spectacol;
    }

    public Loc getLoc() {
        return loc;
    }

    public void setareLoc(Loc loc) {
        this.loc = loc;
    }

    public void show() {
        System.out.println("BILET {");
        System.out.println("Bilet " + getNumarBilet() + ": ");
        client.show();
        loc.show();
        System.out.println("}");
    }
}

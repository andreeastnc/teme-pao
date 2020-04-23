package project.model;

public class Client {
    protected String numeClient;
    protected static int numar = 0;
    protected int numarClient;

    public Client(String numeClient) {
        this.numeClient = numeClient;
        this.numarClient = ++numar;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public int getNumarClient() {
        return numarClient;
    }

    public double getPret(double pret) {
        return pret;
    }

    public int tip() {
        return 0;
    }

    public void show() {
        System.out.println("Client " + getNumarClient() + ": " + getNumeClient() + ", " + "fara discount");
    }
}

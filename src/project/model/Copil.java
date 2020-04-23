package project.model;

import java.util.Date;

public class Copil extends Client{
    private final int discount = 100;
    //private Date data;

    public Copil(String numeClient) {
        super(numeClient);
    }

    public double getDiscount() {
        return discount;
    }

    public final int tip() {
        return 3;
    }

    @Override
    public double getPret(double pret) {
        return 0;
    }

    @Override
    public void show() {
        System.out.println("Client " + getNumarClient() + ": " + getNumeClient() + ", " + "gratuit");
    }
}

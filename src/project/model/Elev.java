package project.model;

public class Elev extends Client{
    private final int discount = 50;

    public Elev(String numeClient) {
        super(numeClient);
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public double getPret(double pret) {
        return super.getPret(pret) * (100 - discount) / 100;
    }

    @Override
    public void show() {
        System.out.println("Client " + getNumarClient() + ": " + getNumeClient() + ", " + "discount de " + (int)getDiscount() + "%");
    }
}
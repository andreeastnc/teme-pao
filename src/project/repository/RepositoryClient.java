package project.repository;

import project.model.*;
import java.util.ArrayList;

public class RepositoryClient {
    private ArrayList<Client> bdClient;

    public RepositoryClient() {
        bdClient = new ArrayList<>();
    }

    public void add(Client client) {
        bdClient.add(client);
    }

    public Client getClientByNumar(int numarClient) {
        for(Client client : bdClient) {
            if(client.getNumarClient() == numarClient) {
                return client;
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudenti() {
        ArrayList<Student> studenti = new ArrayList<>();
        for(Client client : bdClient) {
            if (client instanceof Student) {
                Student student = (Student) client;
                studenti.add(student);
            }
        }
        return studenti;
    }

    public ArrayList<Elev> getAllElevi() {
        ArrayList<Elev> elevi = new ArrayList<>();
        for(Client client : bdClient) {
            if (client instanceof Elev) {
                Elev elev = (Elev) client;
                elevi.add(elev);
            }
        }
        return elevi;
    }

    public ArrayList<Copil> getAllCopii() {
        ArrayList<Copil> copii = new ArrayList<>();
        for(Client client : bdClient) {
            if (client instanceof Copil) {
                Copil copil = (Copil) client;
                copii.add(copil);
            }
        }
        return copii;
    }

    public ArrayList<Pensionar> getAllPensionari() {
        ArrayList<Pensionar> pensionari = new ArrayList<>();
        for(Client client : bdClient) {
            if (client instanceof Pensionar) {
                Pensionar pensionar = (Pensionar) client;
                pensionari.add(pensionar);
            }
        }
        return pensionari;
    }

    public ArrayList<Client> getAll() {
        return bdClient;
    }

    public ArrayList<Client> getClientiDiscount() {
        ArrayList<Client> clientiDiscount = new ArrayList<>();
        for (Client client : bdClient) {
            if ((client instanceof Student) || (client instanceof Elev) || (client instanceof Copil) || (client instanceof Pensionar)) {
                clientiDiscount.add(client);
            }
        }
        return clientiDiscount;
    }


    public ArrayList<Client> getClientiPretIntreg() {
        ArrayList<Client> clientiPretIntreg = new ArrayList<>();
        for(Client client : bdClient) {
            if (!(client instanceof Student) && !(client instanceof Elev) && !(client instanceof Copil) && !(client instanceof Pensionar)) {
                clientiPretIntreg.add(client);
            }
        }
        return clientiPretIntreg;
    }

    public int getNumarClientiDiscount() {
        int count = 0;
        for(Client client : bdClient) {
            if ((client instanceof Student) || (client instanceof Elev) || (client instanceof Copil) || (client instanceof Pensionar)) {
                count++;
            }
        }
        return count;
    }

    public int getNumarClientiPretIntreg() {
        int count = 0;
        for(Client client : bdClient) {
            if (!(client instanceof Student) && !(client instanceof Elev) && !(client instanceof Copil) && !(client instanceof Pensionar)) {
                count++;
            }
        }
        return count;
    }

    public void stergere(Client client) {
        bdClient.remove(client);
    }

    public void showClient(Client client) {
        client.show();
    }
}

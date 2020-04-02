/*
1. DEFINIREA SISTEMULUI:
    Sa se creeze o lista pe baza temei alese cu cel putin 10 actiuni/interogari care se pot face in cadrul sistemului si
     o lista cu cel putin 8 tipuri de obiecte.
2. IMPLEMENTARE: sa se implementeze in limbajul Java o aplicatie pe baza celor definite la primul punct. Aplicatia va
contine:
    - clase simple cu atribute private/protected si metode de acces
    - cel putin doua coletii diferite capabile  sa gestioneze obiectele definite anterior (List, Set, Map etc.) dintre
    care cel putin una sa fie sortata (se vor folosi array-uri uni/bidimensionalel in cazul in care nu se parcurg
    colectiile pana la data checkpoint-ului.
    - utilizare mostenire pt crearea de clase aditionale si utilizarea lor in cadrul colectiilor
    - cel putin o clasa serviciu care sa expuna operatiile cu entitatile diferite
    - clasa main din care sunt facute apeluri catre servicii

*/

//REZERVARE LOC IN SALA DE SPECTACOL (SPECTACOL, LOC, CLIENT)
package project.main;

import project.model.*;
import project.service.ServiceBilet;
import project.service.ServiceClient;
import project.service.ServiceSpectacol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //initializare clienti
        ServiceClient serviceClient = ServiceClient.getInstanta();

        serviceClient.addClient(new Client("Andrei"));
        serviceClient.addClient(new Client("Simon"));
        serviceClient.addClient(new Client("Levi"));
        serviceClient.addClient(new Student("Lucas"));
        serviceClient.addClient(new Elev("Damien"));
        serviceClient.addClient(new Copil("Julien"));
        serviceClient.addClient(new Pensionar("Henry"));
        serviceClient.addClient(new Student("Lys"));

        //afisare clienti
        ArrayList<Client> clienti = serviceClient.getAllClienti();
        System.out.println("AFISARE CLIENTI:");
        for(Client client : clienti) {
            serviceClient.showClient(client);
        }

        System.out.println();
        System.out.println("AFISARE STUDENTI:");
        ArrayList<Student> studenti = serviceClient.getAllStudenti();
        for(Student student : studenti) {
            serviceClient.showClient(student);
        }

        System.out.println();
        System.out.println("AFISARE ELEVI:");
        ArrayList<Elev> elevi = serviceClient.getAllElevi();
        for(Elev elev : elevi) {
            serviceClient.showClient(elev);
        }

        System.out.println();
        System.out.println("AFISARE COPII:");
        ArrayList<Copil> copii = serviceClient.getAllCopii();
        for(Copil copil : copii) {
            serviceClient.showClient(copil);
        }

        System.out.println();
        System.out.println("AFISARE PENSIONARI:");
        ArrayList<Pensionar> pensionari = serviceClient.getAllPensionari();
        for(Pensionar pensionar : pensionari) {
            serviceClient.showClient(pensionar);
        }

        System.out.println();
        System.out.println("Afisarea clientului 10:");
        if(serviceClient.getClientByNumar(10) != null) {
            serviceClient.getClientByNumar(10).show();
        } else {
            System.out.println("Acest client nu exista.");
        }

        System.out.println("Afisarea clientului 6:");
        if(serviceClient.getClientByNumar(6) != null) {
            serviceClient.getClientByNumar(6).show();
        } else {
            System.out.println("Acest client nu exista.");
        }

        System.out.println();
        ArrayList<Client> clientiFaraDiscount = serviceClient.getClientiFaraDiscount();
        System.out.println("Afisare clienti fara discount: ");
        for(Client client : clientiFaraDiscount) {
            serviceClient.showClient(client);
        }

        System.out.println();
        ArrayList<Client> clientiDiscount = serviceClient.getClientiDiscount();
        System.out.println("Afisare clienti cu discount: ");
        for(Client client : clientiDiscount) {
            serviceClient.showClient(client);
        }

        //initializare spectacole
        ServiceSpectacol serviceSpectacol = ServiceSpectacol.getInstanta();

        serviceSpectacol.addSpectacol(new Spectacol("Concert H.U. & Papa Roach", 150, 1000));
        serviceSpectacol.addSpectacol(new Spectacol("Spectacol de teatru", 50, 200));

        System.out.println();
        System.out.println("AFISARE SPECTACOLE:");
        ArrayList<Spectacol> spectacole = serviceSpectacol.getAllSpectacole();
        for(Spectacol spectacol : spectacole) {
            serviceSpectacol.showSpectacol(spectacol);
        }

        System.out.println();
        System.out.println("Afisarea spectacolelor dupa schimbarea pretului:");
        serviceSpectacol.schimbarePretBiletBySpectacolId(1, 75);
        for(Spectacol spectacol: spectacole) {
            serviceSpectacol.showSpectacol(spectacol);
        }

        System.out.println();
        System.out.println("AFISARE SPECTACOLE DUPA PRET:");
        System.out.println("Afisarea spectacolelor care costa 50ron:");
        if(serviceSpectacol.getSpectacolByPret(50) != null) {
            serviceSpectacol.getSpectacolByPret(50).show();
        } else {
            System.out.println("Nu exista spectacole cu pretul de 50ron.");
        }

        //initializare bilete
        ServiceBilet serviceBilet = ServiceBilet.getInstanta();
        serviceBilet.addBilet(new Bilet(serviceSpectacol.getSpectacolById(1), new Loc(1), serviceClient.getClientByNumar(1)));
        serviceBilet.addBilet(new Bilet(serviceSpectacol.getSpectacolById(1), new Loc(2), serviceClient.getClientByNumar(4)));
        serviceBilet.addBilet(new Bilet(serviceSpectacol.getSpectacolById(1), new Loc(3), serviceClient.getClientByNumar(6)));
        serviceBilet.addBilet(new Bilet(serviceSpectacol.getSpectacolById(1), new Loc(3), serviceClient.getClientByNumar(2)));
        
        ArrayList<Bilet> bilete = serviceBilet.getAllBilete();
        System.out.println();
        System.out.println("AFISARE BILETE:");
        for(Bilet bilet : bilete) {
            serviceBilet.showBilet(bilet);
        }

        System.out.println();
        System.out.println("Afisare bilet dupa numar bilet: ");
        serviceBilet.getBiletByNumarBilet(2).show();

        System.out.println();
        System.out.println("Afisarea castigurilor evenimenului cu id-ul 1: ");
        System.out.println(serviceBilet.getCastiguriSpectacolByIdSpectacol(1));

        System.out.println();
        System.out.println("STERGEREA PRIMULUI CLIENT: ");
        serviceClient.removeClientByNumar(1);
        for(Client client : clienti) {
            serviceClient.showClient(client);
        }
        System.out.println();
        for(Bilet bilet : bilete) {
            serviceBilet.showBilet(bilet);
        }
    }
}

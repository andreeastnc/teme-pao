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
import project.service.ServiceClient;
import project.service.ServiceSpectacol;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ServiceClient serviceClient = ServiceClient.getInstanta();
        serviceClient.getClientiDinFisier();

        ServiceSpectacol serviceSpectacol = ServiceSpectacol.getInstanta();
        serviceSpectacol.getSpectacoleDinFisier();

        System.out.println("1. Adauga un client nou.\n" +
                "2. Adauga un spectacol nou.\n" +
                "3. Adauga un bilet nou.\n" +
                "0. Iesire.\n");

        int userChoice = -1;
        do {
            Scanner in = new Scanner(System.in);
            userChoice = in.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("Alege tipul clientului:\n1. Elev\n2. Student\n3. Copil\n4. Pensionar\n5. Niciunul");
                    int userChoice2 = in.nextInt();
                    in.nextLine();
                    System.out.println("Introdu numele clientului: ");
                    String numeClient = in.nextLine();
                    switch (userChoice2) {
                        case 1:
                            serviceClient.addClient(new Elev(numeClient));
                            break;
                        case 2:
                            serviceClient.addClient(new Student(numeClient));
                            break;
                        case 3:
                            serviceClient.addClient(new Copil(numeClient));
                            break;
                        case 4:
                            serviceClient.addClient(new Pensionar(numeClient));
                            break;
                        case 5:
                            serviceClient.addClient(new Client(numeClient));
                            break;
                        default:
                            System.out.println("Optiune invalida!\n");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Introdu numele spectacolului: ");
                    String numeSpectacol = in.nextLine();
                    in.nextLine();
                    System.out.println("Introdu pretul spectacolului: ");
                    int pretSpectacol = in.nextInt();
                    in.nextLine();
                    System.out.println("Introdu numarul de locuri disponibile: ");
                    int numarLocuriSpectacol = in.nextInt();
                    in.nextLine();
                    serviceSpectacol.addSpectacol(new Spectacol(numeSpectacol, pretSpectacol, numarLocuriSpectacol));
                    break;
                case 3:
                    System.out.println("Nu am reusit sa termin aceasta functie. ");
                    break;
                default:
                    System.out.println("Optiune invalida!\n");
                    break;
            }
            System.out.println("1. Adauga un client nou.\n" +
                    "2. Adauga un spectacol nou.\n" +
                    "3. Adauga un bilet nou.\n" +
                    "0. Iesire.\n");
        } while (userChoice != 0);
    }
}
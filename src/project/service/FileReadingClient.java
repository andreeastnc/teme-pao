package project.service;

import project.model.*;

import java.io.*;
import java.util.ArrayList;

public class FileReadingClient {
    private static FileReadingClient instanta = new FileReadingClient();

    public static FileReadingClient getReadingInstanta() {
        return instanta;
    }

    public ArrayList<Client> readClienti() {
        ArrayList<Client> clienti = new ArrayList<>();

        try {
            File f = new File("client.csv");

            if (!f.exists())
                return clienti;

            BufferedReader csv = new BufferedReader(new FileReader(f));

            String line;
            while ((line = csv.readLine()) != null) {
                String[] data = line.split(",");
                switch (data[1]) {
                    case "1":
                        clienti.add(new Elev(data[0]));
                        break;
                    case "2":
                        clienti.add(new Student(data[0]));
                        break;
                    case "3":
                        clienti.add(new Copil(data[0]));
                        break;
                    case "4":
                        clienti.add(new Pensionar(data[0]));
                        break;
                    default:
                        clienti.add(new Client(data[0]));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return clienti;
    }
}
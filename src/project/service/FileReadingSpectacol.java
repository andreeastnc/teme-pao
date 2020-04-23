package project.service;

import project.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadingSpectacol {
    private static FileReadingSpectacol instanta = new FileReadingSpectacol();

    public static FileReadingSpectacol getReadingInstanta() {
        return instanta;
    }

    public ArrayList<Spectacol> citireSpectacole() {
        ArrayList<Spectacol> spectacole = new ArrayList<>();
        try {
            File f = new File("spectacol.csv");

            if (!f.exists())
                return spectacole;

            BufferedReader csv = new BufferedReader(new FileReader(f));

            String line;
            while ((line = csv.readLine()) != null) {
                String[] data = line.split(",");
                spectacole.add(new Spectacol(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return spectacole;
    }
}
package project.service;

import project.model.Spectacol;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileWritingSpectacol {
    private static FileWritingSpectacol instanta = new FileWritingSpectacol();

    public static FileWritingSpectacol getInstantaScriere() {
        return instanta;
    }

    public void scriereSpectacol(Spectacol spectacol) {
        try (FileWriter csv = new FileWriter("spectacol.csv", true)) {
            List<String> line =  Arrays.asList(spectacol.getNumeSpectacol(), Integer.toString(spectacol.getPret()),
                                Integer.toString(spectacol.getNumarLocuri()));
            csv.append(String.join(",", line));
            csv.append("\n");
            csv.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSpectacole(ArrayList<Spectacol> spectacole) {
        try (FileWriter csv = new FileWriter("spectacol.csv", false)) {
            for(Spectacol spectacol : spectacole) {
                List<String> line = Arrays.asList(spectacol.getNumeSpectacol(), Integer.toString(spectacol.getPret()),
                                Integer.toString(spectacol.getNumarLocuri()));
                csv.append(String.join(",", line));
                csv.append("\n");
                csv.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
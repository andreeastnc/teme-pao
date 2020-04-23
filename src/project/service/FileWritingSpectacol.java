package project.service;

import project.model.Spectacol;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileWritingSpectacol {
    private static FileWritingSpectacol instanta = new FileWritingSpectacol();

    public static FileWritingSpectacol getInstantaScriere() {
        return instanta;
    }

    public Path getPath() {
        return Paths.get("spectacol.csv");
    }

    public void scriereSpectacol(Spectacol spectacol) {
        try (FileWriter csvWriter = new FileWriter(String.valueOf(getPath()), true)) {
            List<String> line =  Arrays.asList(spectacol.getNumeSpectacol(), Integer.toString(spectacol.getPret()),
                                Integer.toString(spectacol.getNumarLocuri()));
            csvWriter.append(String.join(",", line));
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSpectacole(ArrayList<Spectacol> spectacole) {
        try (FileWriter csvWriter = new FileWriter(String.valueOf(getPath()), false)) {
            for(Spectacol spectacol : spectacole) {
                List<String> line = Arrays.asList(spectacol.getNumeSpectacol(), Integer.toString(spectacol.getPret()),
                                Integer.toString(spectacol.getNumarLocuri()));
                csvWriter.append(String.join(",", line));
                csvWriter.append("\n");
                csvWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
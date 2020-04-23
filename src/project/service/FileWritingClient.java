package project.service;


import project.model.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileWritingClient {
    private static FileWritingClient instanta = new FileWritingClient();

    public static FileWritingClient getWritingInstanta() {
        return instanta;
    }

    public Path getPath() {
        return Paths.get("client.csv");
    }

    public void scriereClient(Client client) {
        try(FileWriter csv = new FileWriter(String.valueOf(getPath()), true)) {
            List<String> line =  Arrays.asList(client.getNumeClient(), Integer.toString(client.tip()));
            csv.append(String.join(",", line));
            csv.append("\n");
            csv.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClienti(ArrayList<Client> clients) {
        try(FileWriter csv = new FileWriter(String.valueOf(getPath()), false)) {
                for(Client client : clients) {
                List<String> line = Arrays.asList(client.getNumeClient(), Integer.toString(client.tip()));
                csv.append(String.join(",", line));
                csv.append("\n");
                csv.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
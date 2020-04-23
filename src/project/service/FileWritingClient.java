package project.service;


import project.model.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWritingClient {
    private static FileWritingClient instanta = new FileWritingClient();

    public static FileWritingClient getWritingInstanta() {
        return instanta;
    }

    public void scriereClient(Client client) {
        try(FileWriter csv = new FileWriter("client.csv", true)) {
            List<String> line =  Arrays.asList(client.getNumeClient(), Integer.toString(client.tip()));
            csv.append(String.join(",", line));
            csv.append("\n");
            csv.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClienti(ArrayList<Client> clients) {
        try(FileWriter csv = new FileWriter("client.csv", false)) {
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
package project.service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AuditService {
    private static AuditService instanta = new AuditService();

    public static AuditService getInstanta() {
        return instanta;
    }

    public String getTimestamp() {
        String timeStamp = new SimpleDateFormat("dd.mm.yyyy hh:mm:ss").format(new Date());
        return timeStamp;
    }

    public void actiune(String nume_actiune, String timestamp_actiune) {
        try (FileWriter csv = new FileWriter("serviciu-audit.csv", true)) {
            List<String> line =  Arrays.asList(nume_actiune, timestamp_actiune);
            csv.append(String.join(",", line));
            csv.append("\n");
            csv.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
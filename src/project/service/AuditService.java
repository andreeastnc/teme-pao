package project.service;

import java.io.*;
import java.util.Arrays;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

public class AuditService {
    private static AuditService instanta = new AuditService();

    public static AuditService getInstanta() {
        return instanta;
    }

    public Path getPath() {
        return Paths.get("serviciu-audit.csv");
    }

    public String getTimestamp() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        return ts.toString();
    }

    public void actiune(String nume_actiune, String timestamp_actiune) {
        try (FileWriter csvWriter = new FileWriter(String.valueOf(getPath()), true)) {
            List<String> line =  Arrays.asList(nume_actiune, timestamp_actiune);
            csvWriter.append(String.join(",", line));
            csvWriter.append("\n");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
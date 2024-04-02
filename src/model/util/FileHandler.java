package model.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public boolean saveToFile(String data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace(); 
            return false;
        }
    }

    public boolean clearFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write("");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
package model.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.exceptions.DomainException;

public class FileHandlerLogin {
    private String fileName;

    public FileHandlerLogin(String fileName) {
        this.fileName = fileName;
    }

    public boolean clearFile(String loginOutput, String passwordOutput) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String savedLogin = br.readLine();
            String savedPassword = br.readLine();
            
            if (savedLogin != null && savedPassword != null &&
                savedLogin.equals(loginOutput) && savedPassword.equals(passwordOutput)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new DomainException("Login ou senha incorretos");
    }


    public void readFile(String loginEntry, String passwordEntry) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String savedLogin = br.readLine();
            String savedPassword = br.readLine();

            if (savedLogin != null && savedPassword != null &&
                    savedLogin.equals(loginEntry) && savedPassword.equals(passwordEntry)) {
                return;
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

        throw new DomainException("Login ou senha incorretos");
    }
}


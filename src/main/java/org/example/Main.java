package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        while (true) {
            HttpImageStatusCli statusCli = new HttpImageStatusCli();
            statusCli.askStatus();
        }
    }
}
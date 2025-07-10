package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() throws IOException, URISyntaxException {
        int code = 0;

        System.out.println("Enter HTTP status code");

        Scanner sc = new Scanner(System.in);

        try {
            code = sc.nextInt();
            new HttpStatusImageDownloader().downloadStatusImage(code);
        } catch (InputMismatchException ex) {
            System.out.println("Please enter valid number");
        } catch (FileNotFoundException e) {
            System.out.println("There is not image for HTTP status: " + code);
        }
    }
}

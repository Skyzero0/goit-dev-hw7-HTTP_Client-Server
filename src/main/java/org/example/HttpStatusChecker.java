package org.example;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException, URISyntaxException {
        String imageLine = "https://http.cat/" + code + ".jpg";

        URI uri = new URI(imageLine);
        URL url = uri.toURL();

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseMessage().equals("Not Found")) {
            throw new FileNotFoundException();
        }
        return imageLine;
    }
}

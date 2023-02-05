package ua.goit.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new Exception("Image not found");
            }
        } catch (IOException e) {
            throw new Exception("Image not found");
        }
        return url;
    }
}

package ua.goit.http;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private HttpStatusChecker checker;

    public HttpStatusImageDownloader() {
        this.checker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws Exception {
        String imageUrl = checker.getStatusImage(code);
        try {
            URL url = new URL(imageUrl);
            InputStream in = url.openStream();
            FileOutputStream out = new FileOutputStream("status_" + code + ".jpg");
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = in.read(buffer))) {
                out.write(buffer, 0, n);
            }
            out.close();
            in.close();
        } catch (IOException e) {
            throw new Exception("Failed to download image");
        }
    }
}

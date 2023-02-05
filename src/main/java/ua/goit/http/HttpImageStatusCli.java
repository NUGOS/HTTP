package ua.goit.http;

import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader downloader;

    public HttpImageStatusCli(HttpStatusImageDownloader downloader) {
        this.downloader = downloader;
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            System.out.println("Enter HTTP status code: ");
            String codeInput = scanner.nextLine();
            try {
                int code = Integer.parseInt(codeInput);
                downloader.downloadStatusImage(code);
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            } catch (Exception e) {
                System.out.println("There is no image for HTTP status " + codeInput);
            }
        }
    }
}

package ua.goit.http;

public class Main {
    public static void main(String[] args) {

        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            System.out.println(checker.getStatusImage(200));
            System.out.println(checker.getStatusImage(404));
            System.out.println(checker.getStatusImage(500));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        try {
            httpStatusImageDownloader.downloadStatusImage(200);
            httpStatusImageDownloader.downloadStatusImage(404);
            httpStatusImageDownloader.downloadStatusImage(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli(new HttpStatusImageDownloader());
        httpImageStatusCli.askStatus();
    }
}

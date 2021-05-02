package test1;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.currentTimeMillis;


public class QuotesProducer {

    @SneakyThrows
    public static void main(String[] args) {
        int lastQuotId = getLastQuotId();
        String lineText = getRandomQuote();
        QuoteInfo lineQuoteInfo = new QuoteInfo(lineText, lastQuotId);
        String dateText = Utils.getCurrentTimeFotTextName();

        Utils.writeObjectToFile(QuotesPath + dateText + " .txt", lineQuoteInfo);
    }

    @SneakyThrows
    private static String getRandomQuote()  {
        String text = new String(Files.readAllBytes(Paths.get("c:\\tmp\\q.txt")), StandardCharsets.UTF_8);

        String[] lines = text.split("\r\n");
        int randomNum = ThreadLocalRandom.current().nextInt(0, lines.length);
        String lineText = lines[randomNum];
        return lineText;
    }




    private static int getLastQuotId() throws IOException {
        String currentCounter = new String(Files.readAllBytes(Paths.get("c:\\tmp\\counter.txt")), StandardCharsets.UTF_8);
        int lastQuotId = Integer.parseInt(currentCounter);
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\tmp\\counter.txt"));
        writer.write(String.valueOf(lastQuotId +1));
        writer.close();
        return lastQuotId;
    }


    private  static  String QuotesPath="c:\\tmp\\quotsObjects\\";
}

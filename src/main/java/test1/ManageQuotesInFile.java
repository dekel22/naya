package test1;

import lombok.SneakyThrows;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class ManageQuotesInFile implements GetRandomQuoteText{
    String quotesFilePath= "c:\\tmp\\q.txt";

    @SneakyThrows
    public String getRandomQuoteText() {
            String text = Files.readString(Paths.get(quotesFilePath));
            String[] lines = text.split("\r\n");
            int randomNum = ThreadLocalRandom.current().nextInt(0, lines.length);
            return lines[randomNum];
    }
}




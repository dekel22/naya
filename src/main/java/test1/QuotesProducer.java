package test1;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class QuotesProducer {

    private  static  String quotesPath="C:\\tmp\\quotesObjects";

    @SneakyThrows
    public static void main(String[] args) {
        GetRandomQuoteText getRandomQuoteText =new ManageQuotesInFile();
        Utils utils= new Utils();

        //not sure about names of interface and it methods
        String lineText = getRandomQuoteText.getRandomQuoteText();
        QuoteInfo lineQuoteInfo = new QuoteInfo(lineText, utils.getLastQuotId());
        String dateText = utils.getCurrentTimeFotTextName();
        utils.writeObjectToFile(quotesPath + dateText , lineQuoteInfo);
    }







}

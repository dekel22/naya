package test1;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.charset.StandardCharsets.UTF_8;

public class QuotesToJsonS {
    private static final  String QuotsSerilazedPath="C:\\tmp\\quotsObjects";
    private static final String jsonLib="C:\\tmp\\jsonlib";
    @SneakyThrows
    public static void main(String[] args) {
        while (true){
            copyFilesToJsonFormat();
            Thread.sleep(10000);
        }

    }

    //todo temp somthing wired with my pem file
    private static String QuoteInfoToJson(QuoteInfo quoteInfo){
        String objInString= "{ \n text: \"" + quoteInfo.getText()+ "\" \n id:" + quoteInfo.getId() + "\"\n type:\"" + quoteInfo.getId();
        return objInString;
    }


    private static void copyFilesToJsonFormat() {
        File f = new File(QuotsSerilazedPath);
        String[] pathNames = f.list();
        if (pathNames.length == 0) return;
        for (String QuotePath : pathNames) {
            QuoteInfo quoteInfo = (QuoteInfo) Utils.readObjectToFile(QuotsSerilazedPath + "\\" + QuotePath);
            Utils.writeStringToFile(jsonLib + Utils.getCurrentTimeFotTextName(), QuoteInfoToJson(quoteInfo));
        }
    }


}

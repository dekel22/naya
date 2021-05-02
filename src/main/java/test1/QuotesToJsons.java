package test1;
import lombok.SneakyThrows;

import java.io.File;

public class QuotesToJsons {
    private  final  String QuotsSerilazedPath="C:\\tmp\\quotsObjects";
    private  final String jsonLib="C:\\tmp\\jsonlib";
    private Utils utils=new Utils();
    private static int sleepDuration=10000;
    @SneakyThrows
    public static void main(String[] args) {
        QuotesToJsons quotesToJsons=new QuotesToJsons();
        while (true){
            quotesToJsons.copyFilesToJsonFormat();
            Thread.sleep(sleepDuration);
        }

    }

    //todo temp something wired with my pem file
    private  String QuoteInfoToJson(QuoteInfo quoteInfo){
        String objInString= "{ \n text: \"" + quoteInfo.getText()+ "\" \n id:" + quoteInfo.getId() + "\"\n type:\"" + quoteInfo.getId();
        return objInString;
    }


    private  void copyFilesToJsonFormat() {
        File f = new File(QuotsSerilazedPath);
        String[] pathNames = f.list();
        if (pathNames.length == 0) return;
        for (String QuotePath : pathNames) {
            QuoteInfo quoteInfo = (QuoteInfo) utils.readObjectToFile(QuotsSerilazedPath + "\\" + QuotePath);
            utils.writeStringToFile(jsonLib + utils.getCurrentTimeFotTextName(), QuoteInfoToJson(quoteInfo));
        }
    }
    QuotesToJsons(){

    }


}

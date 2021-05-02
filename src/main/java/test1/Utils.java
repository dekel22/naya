package test1;

import lombok.SneakyThrows;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;

public class Utils {
    @SneakyThrows
    public  void writeObjectToFile(String objectPath, Object obj){
        FileOutputStream fileOut =
                new FileOutputStream(objectPath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

@SneakyThrows
public void writeStringToFile(String text, String path){
    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    writer.write(text);
}

    public  String getCurrentTimeFotTextName() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String dateText=timestamp.toString().replace(" ","-").replace(".","-").replace(":","_");
        return dateText + ".txt";
    }

    @SneakyThrows
    public  Object readObjectToFile(String objectPath){
        FileInputStream fileIn = new FileInputStream(objectPath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        return in.readObject();
    }

    @SneakyThrows
    public int getLastQuotId()  {
        String currentCounter = new String(Files.readAllBytes(Paths.get("c:\\tmp\\counter.txt")), StandardCharsets.UTF_8);
        int lastQuotId = Integer.parseInt(currentCounter);
        BufferedWriter writer = new BufferedWriter(new FileWriter("c:\\tmp\\counter.txt"));
        writer.write(String.valueOf(lastQuotId +1));
        writer.close();
        return lastQuotId;
    }


    private  static  String QuotesPath="c:\\tmp\\quotsObjects\\";

}

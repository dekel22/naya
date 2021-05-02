package test1;

import lombok.SneakyThrows;

import java.io.*;
import java.sql.Timestamp;

public class Utils {
    @SneakyThrows
    public static void writeObjectToFile(String objectPath, Object obj){
        FileOutputStream fileOut =
                new FileOutputStream(objectPath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
        System.out.println("dd");
    }

@SneakyThrows
public static void writeStringToFile(String text, String path){
    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
    writer.write(text);
}

    public static String getCurrentTimeFotTextName() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String dateText=timestamp.toString().replace(" ","-").replace(".","-").replace(":","_");
        return dateText;
    }

    @SneakyThrows
    public static Object readObjectToFile(String objectPath){
        FileInputStream fileIn = new FileInputStream(objectPath);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        return in.readObject();
    }

}

package app;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Logs {

    /**
     * Метод читает файл с логами.
     */
    public static String readLogs(){
        String txt = "";
        try {
            File loadFile = new File("./src/logs/logs.txt");
            FileReader reader = new FileReader(loadFile);
            txt = reader.toString();
        }
        catch (IOException e){
            Server.chat.setText("Ошибка при загрузке лога");
        }
        return txt;
    }

    /**
     * Метод записывает текущее сообщение в файл с логами.
     * @param txt Текущее сообщение.
     */
    public static void saveLogs(String txt){
        try {
            File saveFile = new File("./src/logs/logs.txt");
            FileWriter writer = new FileWriter(saveFile, true);
            writer.write(txt);
            writer.close();

        } catch (IOException e) {
            Server.chat.setText(txt + "\nОшибка при сохранении лога");
        }
    }
}

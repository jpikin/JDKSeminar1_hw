package app;


import java.io.*;

public class Logs {

    /**
     * Метод читает и возвращает файл с логами.
     */
    public static String readLogs() {
        StringBuilder txt = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/logs/logs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txt.append(line+'\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return txt.toString();
    }

    /**
     * Метод записывает текущее сообщение в файл с логами.
     *
     * @param txt Текущее сообщение.
     */
    public static void saveLogs(String txt) {
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

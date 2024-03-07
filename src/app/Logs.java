package app;

import java.io.File;

public class Logs {
    private File file = new File("./src/logs/logs.txt");

    /**
     * Метод читает файл с логами.
     */
    public static void readLogs(){

    }

    /**
     * Метод записывает текущее сообщение в файл с логами.
     * @param txt Текущее сообщение.
     */
    public static void saveLogs(String txt){
        String toLogfile = txt;
        System.out.println(txt);
    }
}

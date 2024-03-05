package app;

import java.io.File;

public class Logs {
    File file = new File("./src/logs/logs.txt");
    public static void readLogs(){

    }
    public static void saveToLogsFile(String txt){
        String toLogfile = txt;
        System.out.println(txt);
    }
}

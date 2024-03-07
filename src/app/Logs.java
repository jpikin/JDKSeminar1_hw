package app;

import java.io.File;

public class Logs {
    private File file = new File("./src/logs/logs.txt");
    public static void readLogs(){

    }
    public static void saveLogs(String txt){
        String toLogfile = txt;
        System.out.println(txt);
    }
}

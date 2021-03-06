package util;

import java.io.*;
import java.util.Properties;

public class Local {

    private static Properties properties;
    static File file = new File("saved.retrivia");

    public static void init(){
        properties = new Properties();
        try {
            InputStream in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            fileNotFoundAction(file);
            System.exit(0);
        }
    }

    public static boolean propExist(String key) {
        if (properties.getProperty(key) == null) {
            return false;
        } else {
            return true;
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }

    public static void addKey(String hash, String name) {
        properties.put(hash, name);
        try {
            properties.store(new FileOutputStream(file), "retrivia");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteKey(String hash) {
        properties.remove(hash);
    }

    private static void fileNotFoundAction(File f){
        try {
            properties.store(new FileOutputStream(f), "retrivia");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getKeySize() {
        return properties.size();
    }

    public static void getKeyInt(int i) {
        properties.get(i);
    }

}

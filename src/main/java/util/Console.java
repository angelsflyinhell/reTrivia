package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

    public static void printReady() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
        try {
            String search = br.readLine();
            System.out.println(Local.getValue(search));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printReady();
    }

}

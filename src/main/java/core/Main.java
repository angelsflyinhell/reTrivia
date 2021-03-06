package core;

import util.Data;
import util.Local;

public class Main {

    public static void main(String[] args) {
        Local.init();
//        Console.printReady();
        while(true) {
            Data.download();
        }
    }

}

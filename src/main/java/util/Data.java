package util;

import Requests.OpenTDB;
import org.jsoup.Jsoup;

public class Data {

    public static void download() {
        OpenTDB obj = new OpenTDB();
        obj.getTrivia();
        if(!Local.propExist(obj.question)) {
            Local.addKey(Jsoup.parse(obj.question).text(), Jsoup.parse(obj.correctAnswer).text());
            System.out.println("[reTrivia Local] Saved '" + Jsoup.parse(obj.question).text() + "' with '" + Jsoup.parse(obj.correctAnswer).text() + "'");
        }else {
            Local.addKey(Jsoup.parse(obj.question).text(), Jsoup.parse(Local.getValue(obj.question)).text());
            Local.deleteKey(obj.question);
            System.out.println("[reTrivia Local] Relocated '" + Jsoup.parse(obj.question).text() + "'");
        }
    }

}

package aufgabe2;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * TestKlasse
 */
public class TestKlasse
{
    public void test_1(){
        Lager lager = new Lager("Lager", 50);
        Artikel artikel10 = new Artikel(4521, "Stuhl", 8, 9.99 );
        Artikel artikel20 = new Artikel(8512, "Ball", 9, 10);
        Artikel artikel30 = new Artikel(8521, "Trikot", 12, 89);

        CD cd10= new CD(1200, "cd10", 5, 10, "interpret10", "titel10", 15);
        CD cd20 = new CD(1298, "cd20", 9, 20, "interpret20", "titel20", 10);
        CD cd30 = new CD(8536, "cd30", 2, 100, "interpret30", "titel30", 53);

        Video video10 = new Video(8901, "video10", 8, 9.99, "titel10", 105, 2006);
        Video video20 = new Video(4278, "video20", 2, 310, "titel20", 130, 2010);
        Video video30 = new Video(3652, "video30", 92, 89.1, "titel30", 153, 1999);

        Buch buch10 = new Buch(7986, "buch10", 18, 19.99, "titel01", "autor10", "verlag10");
        Buch buch20 = new Buch(4654, "buch20", 17, 1, "titel20",  "autor20", "verlag20");
        Buch buch30 = new Buch(3028, "buch30", 2, 10.35, "titel30",  "autor30", "verlag30");

        lager.legeArtikelAn(artikel10);
        lager.legeArtikelAn(artikel20);
        lager.legeArtikelAn(artikel30);

        lager.legeArtikelAn(cd10);
        lager.legeArtikelAn(cd20);
        lager.legeArtikelAn(cd30);

        lager.legeArtikelAn(video10);
        lager.legeArtikelAn(video20);
        lager.legeArtikelAn(video30);

        lager.legeArtikelAn(buch10);
        lager.legeArtikelAn(buch20);
        lager.legeArtikelAn(buch30);

        String autor = "autor1";

        Consumer<Artikel> plus10Prozent = x -> x.setArtikelpreis(x.getArtikelpreis() * 1.1);
        Consumer<Artikel> minus5Prozent = x -> x.setArtikelpreis(x.getArtikelpreis() * 0.95);

        Predicate<Artikel> instanceofCd = x -> x instanceof CD;
        Predicate<Artikel> instanceofBuch = x -> x instanceof Buch;

        Predicate<Artikel> bestandgleich2 = x -> x.getArtikelbestand() == 2;
        Predicate<Artikel> gleicherAutor = x -> ((Buch) x).getAutor().equals(autor);

        lager.applyToSomeArticles(plus10Prozent, instanceofCd);
        lager.applyToSomeArticles(minus5Prozent, bestandgleich2);
        lager.applyToSomeArticles(minus5Prozent, instanceofBuch.and(gleicherAutor));
        lager.applyToSomeArticles(plus10Prozent.andThen(minus5Prozent), instanceofCd.and(bestandgleich2));

        System.out.println(lager.ausgebenBestandsListe());
        System.out.println(lager.filterAll( x -> x.getArtikelnummer() < 8000, x -> x.getArtikelbestand() < 60, x -> x.getArtikelpreis() < 10));

    }
    public static void main(String[] args){
        TestKlasse test = new TestKlasse();
        test.test_1();
    }
}

package aufgabe2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * Décrivez votre classe TestKlasse ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TestKlasse
{
public void test_2(){

  Lager lager = new Lager("Lager", 50);

  Artikel artikel1 = new Artikel(4521, "Stuhl", 8, 9.99 );
  Artikel artikel2 = new Artikel(8512, "Ball", 9, 10);
  Artikel artikel3 = new Artikel(8521, "Trikot", 12, 89);

  CD cd1 = new CD(1200, "cd1", 5, 10, "interpret1", "titel1", 15);
  CD cd2 = new CD(1298, "cd2", 9, 20, "interpret2", "titel2", 10);
  CD cd3 = new CD(8536, "cd3", 2, 100, "interpret3", "titel3", 53);

  Video video1 = new Video(8901, "video1", 8, 9.99, "titel1", 105, 2006);
  Video video2 = new Video(4278, "video2", 2, 310, "titel2", 130, 2010);
  Video video3 = new Video(3652, "video3", 92, 89.1, "titel3", 153, 1999);

  Buch buch1 = new Buch(7986, "buch1", 18, 19.99, "titel1", "autor1", "verlag1");
  Buch buch2 = new Buch(4654, "buch2", 17, 1, "titel2",  "autor2", "verlag2");
  Buch buch3 = new Buch(3028, "buch3", 2, 10.35, "titel3",  "autor3", "verlag3");

  lager.legeArtikelAn(artikel1);
  lager.legeArtikelAn(artikel2);
  lager.legeArtikelAn(artikel3);

  lager.legeArtikelAn(cd1);
  lager.legeArtikelAn(cd2);
  lager.legeArtikelAn(cd3);

  lager.legeArtikelAn(video1);
  lager.legeArtikelAn(video2);
  lager.legeArtikelAn(video3);

  lager.legeArtikelAn(buch1);
  lager.legeArtikelAn(buch2);
  lager.legeArtikelAn(buch3);
  
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
  // manque v
  lager.filterAll( x -> x.getArtikelnummer() < 8000, x -> x.getArtikelbestand() < 60, x -> x.getArtikelpreis() < 10);
  

}

public static void main(String[] args){
    
    TestKlasse test = new TestKlasse();
    
    //test.test_1();
    test.test_2();
}
}

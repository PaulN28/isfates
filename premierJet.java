/*public static void test(String[] args){
    Artikel stuhl = new Artikel(4521, "Stuhl", 8, 9.99 );
    Artikel ball = new Artikel(8512, "ball", 9, 10);
    Artikel trikot = new Artikel(8521, "trikot", 12, 89);
    Lager lager = new Lager();
    lager.legeArtikelAn(stuhl);
    lager.legeArtikelAn(ball);
    lager.legeArtikelAn(trikot);
    System.out.println(lager.filter((Artikel x) -> x.getArtikelbestand() > 8 ));
  }*/

  private ArrayList<Artikel> filter(Predicate<Artikel> filterFunction){
    ArrayList<Artikel> filteredArray = new ArrayList<Artikel>();
    for(int i = 0; i < anzArtikel; i++){
      if (filterFunction.test(lager[i]) == true){
        filteredArray.add(lager[i]);
      }
    }
    return filteredArray;
  }

  private void applyToArticles(Consumer<Artikel> operation){
    for(int i = 0; i < anzArtikel; i++){
      operation.accept(lager[i]);
    }
  }

  public void applyToSomeArticles(Consumer<Artikel> operation, Predicate<Artikel> filterFunction) {
    for (int i = 0; i < anzArtikel; i++) {
      if (filterFunction.test(lager[i]) == true) {
        operation.accept(lager[i]);
      }
    }
  }
    public static void main(String[] args){
      Artikel trikot = new Artikel(8521, "trikot", 12, 89);
      Artikel ball = new Artikel(7896, "ball", 56, 15);
      Artikel schienbeinschoner = new Artikel(4523, "schienbeinschoner", 85, 30.0);
      Lager lager = new Lager();
      lager.legeArtikelAn(trikot);
      lager.legeArtikelAn(ball);
      lager.legeArtikelAn(schienbeinschoner);
      lager.applyToSomeArticles((Artikel y) -> y.setArtikelbezeichnung(y.getArtikelbezeichnung() + " Sonderangebot"), (Artikel x) -> x.getArtikelbestand() > 48 );
      System.out.println(trikot.toString());
      System.out.println(ball.toString());
      System.out.println(schienbeinschoner.toString()) ;
  }

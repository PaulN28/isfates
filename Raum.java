 

public class Raum {
	private int gebaeude;
	private int etage;
	private int raum;
	private static int istReserviert = 0;

	public Raum(int gebaeude, int etage, int raum) {
		this.gebaeude = gebaeude;
		this.etage = etage;
		this.raum = raum;
	}
	
	public String toString() {
		if(getIstReserviert() == 1) {
			System.out.println(String.format("Raum %d-%d.%d", gebaeude, etage, raum));
			System.out.println("fdkfldkf");
			return String.format("gebucht von %s %s (%s) von %s Uhr bis %s für %s", 
									Person.getVorname(), 
									Person.getName(),
									Mitarbeiter.getEmail(),
									Mitarbeiter.getBegin(),
									Mitarbeiter.getEnde(),
									Mitarbeiter.getName()
									);
		}
		return String.format("Raum %d-%d.%d", gebaeude, etage, raum);
	}
	
	public static int getIstReserviert() {
		return istReserviert;
	}

	public static void setIstReserviert(int wert) {
		istReserviert = wert;
	}
}

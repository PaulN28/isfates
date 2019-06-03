 

public class Uhrzeit {
	private static int stunden;
	private static int minuten;
	
	public static int getStunden() {
		return stunden;
	}

	public static void setStunden(int stunden) {
		Uhrzeit.stunden = stunden;
	}

	public static int getMinuten() {
		return minuten;
	}

	public static void setMinuten(int minuten) {
		Uhrzeit.minuten = minuten;
	}

	public Uhrzeit(int stunden, int minuten) {
		check(stunden >= 0 && stunden <= 24, "Hours cannot be negative nor can they be superior to 24");
		check(minuten >= 0 && minuten <= 60, "minutes cannot be negative nor can they be superior to 60");
		this.stunden = stunden;
		this.minuten = minuten;
	}
	
	public String toString() {
		return String.format("%d:%d Uhr", stunden, minuten);
	}
	
	public void check(boolean condition, String message) {
		if (condition != true){
			System.out.println(message);
		}
	}
}

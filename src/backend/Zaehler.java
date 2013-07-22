package backend;

public class Zaehler {

	private long id;
	private String date;
	private String zaehlerStand;
	private String zaehlerart;

	
	public Zaehler(String date, String zaehlerStand, String zaehlerart) {
		super();
		this.date = date;
		this.zaehlerStand = zaehlerStand;
		this.zaehlerart = zaehlerart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getZaehlerStand() {
		return zaehlerStand;
	}

	public void setZaehlerStand (String zaehlerStand) {
		this.zaehlerStand = zaehlerStand;
	}
	
	public String getZaehlerart	()	{
		return zaehlerart;
	}
	
	public void setZaehlerart (String zaehlerart) 	{
		this.zaehlerart = zaehlerart;
	}
	
	public String toString()
	{
		return Long.toString(this.id) + "; Datum: " + this.date + "; Stand: " + this.zaehlerStand + "; ZŠhler: "+ this.zaehlerart;
	}
	

}

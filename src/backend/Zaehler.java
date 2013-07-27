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
		if(this.zaehlerart.equals("gas")) {
			return Long.toString(this.id) + ";" + this.date + ";" + this.zaehlerStand +" m3;"+ this.zaehlerart;
		}
		else if(this.zaehlerart.equals("electric")) {
			return Long.toString(this.id) + ";" + this.date + ";" + this.zaehlerStand +" kWh;"+ this.zaehlerart;
		}
		else if(this.zaehlerart.equals("water")) {
			return Long.toString(this.id) + ";" + this.date + ";" + this.zaehlerStand +" m3;"+ this.zaehlerart;
		}
		else return Long.toString(this.id) + this.zaehlerart;
	}
	
}

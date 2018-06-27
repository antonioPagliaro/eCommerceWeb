package eCommerce;


import java.util.Date;

public class Check {

	private Date date;
	
	private double importo;

//costruttore
	public Check(Date date, double importo) {
		this.date = date;
		this.importo = importo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	
	
	
	
	
	
	
}

package se.hitta.recruitment.server;

public class Name {

	public Name(String given, String family) {
		super();
		this.given = given;
		this.family = family;
	}

	private String given;
	private String family;

	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "Name [given=" + given + ", family=" + family + "]";
	}



}
package se.hitta.recruitment.server;

import java.util.List;

public class Person {

	private Name name;
	private String gender;
	private List<String> email = null;
	private String homepage;

	public Name getName() {
		return name;
	}

	public Person(Name name, String gender, List<String> email, String homepage) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.homepage = homepage;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", email=" + email + ", homepage=" + homepage + "]";
	}

}
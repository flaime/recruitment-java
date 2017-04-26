package se.hitta.recruitment.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DataKeper {

	private ConcurrentHashMap<Integer, Person> persons = new ConcurrentHashMap<Integer, Person>();
	private int nextId =0;
	//skulle kunna skriva en egen trådhantering som skulle kunna funka något bättre i en del fall men tycker denna lösning är ok men beror lite på.
	//tänkte annars andvända en inmemmory databas typ http://prevayler.org/ men har av tid inte hunnit tyvär
	//Har skrivit viss dokumentation för put och post som är mest intresangta för hur de funkar
	
	public DataKeper() {
		persons.put(1, new Person(new Name("Erik1", "karlson1"), "male", Arrays.asList("erik@hello.se","erikhello@hello.se"), "hello.se"));
    	persons.put(2, new Person(new Name("Kalle2", "karlson2"), "female", Arrays.asList("erik@hello.se","erikhello@hello.se"), "hello.se"));
    	persons.put(3, new Person(new Name("Maja3", "karlson3"), "male", Arrays.asList("erik@hello.se","erikhello@hello.se"), "hello.se"));
    	persons.put(4, new Person(new Name("Erika4", "karlson4"), "female", Arrays.asList("erik@hello.se","erikhello@hello.se"), "hello.se"));
	}
	
    public Person getPerson(int number){
    	return persons.get(number);
    }
    
    public List<Person> getAllMale() {
    	return getGender("male");
	}
    public List<Person> getGender(String gender) {
    	ArrayList<Person> ret = (ArrayList<Person>) persons.entrySet()
    			.stream()
    			.filter(x -> x.getValue().getGender().equalsIgnoreCase(gender))
    			.map(Map.Entry::getValue)
    			.collect(Collectors.toList());
    	
    	return ret;
    }

	public List<Person> getAllFemale() {
		return getGender("female");
	}
	/**
	 * Saves the Person p and if is exist a person what it the same id it will be overwritten
	 * @param p a Person that is being added to the data container
	 */
	public void putPerson(int id, Person p){
		persons.put(new Integer(id), p );
	}
	/**
	 * This creates an new id and storese the person for that id, if the same person i being stored on more time it wil get an new id and be stored.
	 * So for updating a person use putPerson instead
	 * @param p
	 * @return
	 */
	public int postPerson(Person p){
		persons.put(new Integer(nextId), p );
		return nextId++;
	}
}

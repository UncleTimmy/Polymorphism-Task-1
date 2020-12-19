
import java.util.*;

class Plant {

	private String name = "N/A";
	private String color = "N/A";

	public Plant() {
		
	}

	public Plant(String n, String c) {

		this.name = n;
		this.color = c;
	}

	public String getName() {

		return this.name;
	}

	public String getColor() {

		return this.color;
	}

	public void setName(String n) {

		this.name = n;
	}

	public void setColor(String c) {

		this.color = c;
	}

	public String toString() {

		return "Name = " + this.name + ", Color = " + this.color;
	}

}

class Flower extends Plant {

	private boolean hasSmell;
	private boolean hasThorn;

	public Flower() {

	}

	public Flower(String n, String c, boolean smell, boolean thorn) {

		super(n, c);

		this.hasSmell = smell;
		this.hasThorn = thorn;

	}

	public boolean getHasSmell() {

		return this.hasSmell;
	}

	public boolean getHasThorn() {

		return this.hasThorn;
	}

	public void setHasSmell(boolean smell) {

		this.hasSmell = smell;
	}

	public void setHasThorn(boolean thorn) {

		this.hasThorn = thorn;
	}

	public String toString() {

		return super.toString() + ", hasSmell=" + this.hasSmell + ", hasThorn=" + this.hasThorn;
	}

}

class Herb extends Plant {

	private boolean isMedicinal;
	private String Season;

	public Herb() {

	}

	public Herb(String n, String c, boolean medicinal, String season) {

		super(n, c);

		this.isMedicinal = medicinal;
		this.Season = season;
	}

	public boolean getIsMedicinal() {

		return this.isMedicinal;
	}

	public String getSeason() {

		return this.Season;
	}

	public void setIsMedicinal(boolean medicinal) {

		this.isMedicinal = medicinal;
	}

	public void setSeason(String season) {

		this.Season = season;
	}

	public String toString() {

		return super.toString() + ", isMedicinal=" + this.isMedicinal + ", Season=" + this.Season;
	}

}

public class Task1 {

	public static Scanner in = new Scanner(System.in);

	public static Plant[] plants = new Plant[5];
	public static int plantCount = -1; // array is empty
	public static int findPlant = -1; // findPlant is false / count has not been initiated

	public static void main(String[] args) {

		Plant p = new Plant("Almond", "Brown"); // creating plant object
		add(p); // added Almond to the array
		p = new Herb("Tulsi", "Green", true, "All"); // Herb is a subclass, so using polymorphism
		add(p); // added herb to the array
		p = new Flower("Rose", "Red", true, true); // Flower is also a subclass of plant so
		add(p); // added flower to the array

		display(); // displaying the new object arrays [0] = Plant("Almond", "Brown")
				   // array [1] = Herb("Tulsi", "Green", true, "All")
				   // array [2] = Flower("Rose", "Red", true, true)

		remove("Tulsi"); // Calling remove to delete Tulsi

		display();
		
		System.out.println("Plant [" + search("Almond")+ "]"); 
		System.out.println("Plant [Name = N/A, Colour = N/A]");
		//System.out.println("Plant [" + search("Tulsi")+ "]");
		

	}

	public static void add(Plant p) {
		plants[++plantCount] = p;
	}

	

	public static void remove(String delete) { // delete contains string tulsi
		for(int i = 0; i < plantCount; i++) {
			if(plants[i].getName() == delete) { // matching the name of tulsi in the list of object arrays
				plants[i] = plants[i + 1]; // if matched, the object of flower in the next array is assigned to plants[i]
		}
			plantCount--; // plant count is reduced
		}
	}
	
  



	public static void display() {

		System.out.println("Plant [" + plants[0].toString() + "]");
		System.out.println("Herb [" + plants[1].toString() + "]");
		System.out.println("Flower [" + plants[2].toString() + "]");
	}
	
	public static Plant search(String find) {

		for(int i = 0; i < plants.length; i++) {
			
			if(plants[i].getName().equals(find)) { //if the names in the array list matches the string
				
				 findPlant = i; //find plant will be assigned the current value of i
				 
				 break; // the loop will break
			}
			
		}
		
		if(findPlant >= 0) //if findPlant no. has been changed, then the search is successful
			return plants[findPlant]; // the array containing the object == array[findPlant] 
		else {
			Plant plant = new Plant(); // if search unsuccessful then a new array is defined
			return plant; // the new array containing default name and colour is returned
		}
	
	}

}


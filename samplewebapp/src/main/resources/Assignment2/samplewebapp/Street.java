package samplewebapp;

public class Street {
	
	int id, AmountOfParks;
	String Name;
	float cost;
	
	
	
	public Street(int id, String Name, int AmountOfParks, float cost)
	{
		this.id = id; 
		this.Name = Name;
		this.AmountOfParks = AmountOfParks;
		this.cost = cost;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getAmountOfParks() {
		return AmountOfParks;
	}



	public void setAmountOfParks(int amountOfParks) {
		AmountOfParks = amountOfParks;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public float getCost() {
		return cost;
	}



	public void setCost(float cost) {
		this.cost = cost;
	}

}

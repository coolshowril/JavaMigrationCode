package Zoo;

public class ZooAddress 
{

	private int idZooAddress;
    private String Address1,Address2,City,State,Country;
    private int IdZooSite,IdZooAnimals,Counts;
    private String Animals,AnimalType,FoodType;
    
    
	public ZooAddress(int idZooAddress, int idZooAnimals,int counts) 
	{
		super();
		this.idZooAddress = idZooAddress;
		this.IdZooAnimals = idZooAnimals;
		this.Counts = counts;
	}
	public ZooAddress(String animals, String animalType,String foodType) 
	{
		super();
		this.Animals = animals;
		this.AnimalType = animalType;
		this.FoodType = foodType;
	}
	public ZooAddress(String address1, String address2,String city, String state, String country)
	{
		super();
		this.Address1 = address1;
		this.Address2 = address2;
		this.City = city;
		this.State = state;
		this.Country = country;
	}
    public String getAnimals() {
		return Animals;
	}
	public void setAnimals(String animals) {
		Animals = animals;
	}
	public String getAnimalType() {
		return AnimalType;
	}
	public void setAnimalType(String animalType) {
		AnimalType = animalType;
	}
	public String getFoodType() {
		return FoodType;
	}
	public void setFoodType(String foodType) {
		FoodType = foodType;
	}
 	public int getIdZooSite() {
		return IdZooSite;
	}
	public void setIdZooSite(int idZooSite) {
		IdZooSite = idZooSite;
	}
	public int getIdZooAnimals() {
		return IdZooAnimals;
	}
	public void setIdZooAnimals(int idZooAnimals) {
		IdZooAnimals = idZooAnimals;
	}
	public int getCounts() {
		return Counts;
	}
	public void setCounts(int counts) {
		Counts = counts;
	}
	public int getIdZooAddress() {
		return idZooAddress;
	}
	public void setIdZooAddress(int idZooAddress) {
		this.idZooAddress = idZooAddress;
	}
	public String getAddress1() {
		return Address1;
	}
	public void setAddress1(String address1) {
		Address1 = address1;
	}
	public String getAddress2() {
		return Address2;
	}
	public void setAddress2(String address2) {
		Address2 = address2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}

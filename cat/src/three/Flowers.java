package three;

public abstract class Flowers {
	private String name;
	public int cost;
	
	public Flowers(String name,int cost){
		this.name= name;
		this.cost = cost;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCost(){
		return cost;
	}
}

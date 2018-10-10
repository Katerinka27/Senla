package three;

public abstract class Flowers {
	private String name;
	public abstract int getCost();
	
	public Flowers(String name){
		this.name= name;
	}
}

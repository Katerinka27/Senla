package three;

public class Chamomile extends Flowers {
	private int cost;
	Chamomile(String name,int cost) {
	super(name);
	this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
}

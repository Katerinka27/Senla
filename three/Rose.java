package three;

public  class Rose extends Flowers {
	private int cost;
	Rose(String name,int cost) {
		super(name);
		this.cost = cost;
		}
	public int getCost() {
		return cost;
	}
}

package Two;

import java.util.Random;

public class Generic {
	Random rand = new Random();
	private int min_value = 100;
	private int max_value = 999;
	public int rand()
	{
		int a = rand.nextInt(max_value-min_value)+min_value;
		return a ;
	}
}

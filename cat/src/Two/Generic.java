package Two;

import java.util.Random;

public class Generic {
	Random rand = new Random();
	private int min = 100;
	private int max = 1000;
	public int rand(){
		return rand.nextInt(max - min) + min;
	}
}

package Two;
import java.util.ArrayList;

public class Numbers {
	ArrayList<Integer> numb = new ArrayList<Integer>();
	public void F(Generic gen) {
		int b = 0;
	for (int i = 0;i<3;i++)	{
		numb.add(gen.rand());
		System.out.println("Число" + " " +numb.get(i));
	}
	
	for (int i = 0;i<3;i++)	{
		b +=numb.get(i) / 100;
	}
	System.out.println("Сумма их первых цифр " + b);
}
}

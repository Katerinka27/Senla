package three;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		ArrayList<Flowers> bouqet = new ArrayList<Flowers>();
		bouqet.add(new Rose("����", 10));
		bouqet.add(new �hamomile("�������", 5));
		int sum = 0;
				
		for(Flowers f : bouqet)
		{
			sum += f.getCost();
		}
		
		System.out.println("����� ������ " + ", " + "��� ��������� - " + sum);			
	}
}

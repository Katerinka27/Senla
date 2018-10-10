package first;

public class Length {
	
	public void mas1(Elements eL) {
		int b = 0;
		int c = 0;
	for(int i = 0;i<eL.getlength();i++)
	{
		if (eL.getElMas(i).length()>b)
		{
			b = eL.getElMas(i).length();
			c = i;
		}
	}
	System.out.println("Элемент с индексом - " + " " +c + ", " + "его длинв " +b);
	}
}

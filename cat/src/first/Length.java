package first;

public class Length {
	
	public void findLongestWord(Elements eL) {
		int b = 0;
		int c = 0;
	for(int i = 0;i<eL.getlength();i++){		
		if (eL.getElArray(i).length()>b){
			b = eL.getElArray(i).length();
			c = i;
		}
	}
	System.out.println("Элемент с индексом - " + eL.getElArray(c) + " max" + ", " +b);
	}
}

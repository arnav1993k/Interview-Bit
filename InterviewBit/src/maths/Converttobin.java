package maths;

public class Converttobin {
	public static String intToBin(int a){
		String s="";
		while(a!=0){
			s=(a%2)+s;
			a=a/2;
		}
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToBin((int)Math.pow(2, 31)));
	}

}

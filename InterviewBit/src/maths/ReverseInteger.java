package maths;

public class ReverseInteger {
	public static int reverse(int a) {
		int res=1;
		int sign=1;
		if(a<0){
			sign=-1;
		}
		a=Math.abs(a);
		res=a%10;
		a=a/10;
		while(a>0){
			res=10*res+a%10;
			if(res%10!=a%10)return 0;
			a=a/10;
			
		}
		
		return res*sign;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1321));
		System.out.println(reverse(-1146467285));
	}

}

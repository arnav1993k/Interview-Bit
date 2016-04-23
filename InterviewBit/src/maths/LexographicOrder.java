package maths;

import java.util.Arrays;

public class LexographicOrder {
	public static long fact(int n){
		if(n==0)return 0;
		long res=1;
		while(n>0){
			res*=n;
			n--;
		}
		return res;
	}
	public static int findRank(String a) {
		int n=a.length();
		char[] c=a.toCharArray();
		char ch='\0';
		String b="";
		Arrays.sort(c);
		for(int i=0;i<n;i++)
		b+=c[i];
		int p=0;
		long res=0;
		for(int i=0;i<n;i++){
			ch=a.charAt(i);
			p=b.indexOf(ch);
			res+=p*fact(n-1-i);
		}
		int r=(int) (res%100003);
		return r;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findRank("abc"));
		System.out.println(findRank("acb"));
		System.out.println(findRank("bac"));
		System.out.println(findRank("bca"));
		System.out.println(findRank("cab"));
		System.out.println(findRank("cba"));
		System.out.println(fact(5));
	}

}

package maths;

import java.util.Arrays;

public class TrailingZeros {
	public static int trailingZeroes(int a) {
	    int[] facts=new int[15];
	    Arrays.fill(facts, 0);
	    for(int i=0;i<15;i++){
	    	if((a/Math.pow(5, i+1))>0)
	    		facts[i]= (a/(int)Math.pow(5, i+1));
	    }
	    int sum=0;
	    for(int i=0;i<15;i++){
	    	sum+=facts[i];
	    }
	    return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(15));
		System.out.println(trailingZeroes(20));
		System.out.println(trailingZeroes(25));
		System.out.println(trailingZeroes(50));
		System.out.println(trailingZeroes(35));
		System.out.println(trailingZeroes(75));
		System.out.println(trailingZeroes(125));
	}

}

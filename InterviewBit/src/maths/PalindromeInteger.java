package maths;

public class PalindromeInteger {
	public static boolean isPalindrome(int a) {
		String str=a+" ";
		str=str.split(" ")[0];
		char[] c=str.toCharArray();
		int n=str.length();
		for(int i=0;i<n;i++){
			if(c[i]!=c[n-1-i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(12121));
	}

}

package maths;

public class ExcelRowtoNum {
	public static int titleToNumber(String a) {
	    int n=a.length();
	   // System.out.println(n);
	    int res=0;
	    char[] c=a.toCharArray();
	   // System.out.println(c);
	    for(int i=n-1;i>=0;i--){
	        int ch=c[i]-64;
	        //System.out.println(ch);
	        
	        res=(int)(Math.pow(26,n-1-i))*ch+res;
	    }
	   // res=res-25;
	    return res;
	}
	public static String numberToTitle(int a) {
	    String res="";
	    int n=a/26;
	    int b=a%26;
	    if(b==0){res="Z"+res; n=n-1;}
	    else
	    	res=(char)(b+64)+res;
	    if(n>0)
	    {
	    
	    		res=numberToTitle(n)+res;
	    
	    }
	    return res;
	}
	public static String toTitle(int n){
		String res="";
		if(n==0)return "Z";
		else{
			while(n>0){
				int b=n%26;
				if(b==0){
					res="Z"+res;
					n=n/26;
					n=n-1;
				}
				else{
					res=((char) (b+64))+res;
					n=n/26;
				}
				
				
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		titleToNumber("AA");
		System.out.println(toTitle(705));
		System.out.println(numberToTitle(677));
	}

}

package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nby3times {
	public static int repeatedNumber(final List<Integer> a) {
		
	    int n=a.size();
	    HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
	    int m=n/3;
	    for(int i=0;i<n;i++){
	    	int now=a.get(i);
	        if(map.containsKey(now)){
	        	int pres=map.get(now);
	        	pres++;
	        	map.put(now, pres);
	        	if(pres>m)return now;
	        }
	        else{
	        	map.put(now,1);
	        	if(1>m)return now;
	        }
	    }
	    return -1;
	   
	}
	public static void main(String[] args) {
		List<Integer> l=new ArrayList<Integer>();
		l.add(1);
		/*l.add(2);
		l.add(3);
		l.add(2);
		l.add(1);
		l.add(1);*/
		System.out.println(repeatedNumber(l));
	}
}

package sorting;

import java.util.ArrayList;
import java.util.Stack;

public class MergeSort {
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    ArrayList<Integer> result=new ArrayList<Integer>();
	    Stack<Integer> stack=new Stack<Integer>();
	    int carry=0;
	    int n=a.size();
	    int sum=a.get(n-1)+1;
	    if(sum>9){
    		carry=1;
    		sum=sum%10;
    	}
	    stack.push(sum);
	    for(int i=n-2;i>=0;i--){
	    	int num=a.get(i);
	    	sum=num+carry;
	    	if(sum>9){
	    		carry=1;
	    		sum=sum%10;
	    	}
	    	else
	    		carry=0;
	    	stack.push(sum);
	    }
	    int last=stack.pop();
	    stack.push(last);
	    if(last==0)
	    stack.push(carry);
	    int cnt=1;
	    while(!stack.isEmpty()){
	    	int e=stack.pop();
	    	if(e==0 && cnt==1){
	    	}
	    	else{
	    		result.add(e);
	    		cnt=0;
	    	}
	    	
	    }
	    return result;
	}
	 public static void main(String args[]) 
	    {
		 ArrayList<Integer> nums=new ArrayList<Integer>();
		 nums.add(0);
		 nums.add(8);
		 nums.add(9);
		 ArrayList<Integer> sum=plusOne(nums);
		 for(Integer i:sum){
			 System.out.println(i);
		 }
	    }
	    
}

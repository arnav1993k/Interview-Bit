package arrays;

import java.util.ArrayList;
import java.util.List;

public class Max_non_negative_subarray {

	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
		int n=a.size();
	    long maxsum=0;
	    long tempsum=0;
	    int start=0; 
	    int end=n;
	    int tempstart=0;
	    int tempend=0;
	    int flag=0;
	    for(int i=0;i<n;i++){
	        if(a.get(i)>=0){
	            if(flag==0){
	                tempstart=i;
	            }
	            tempsum+=a.get(i);
	            tempend=i+1;
	            flag=1;
	        }
	        else{
	            if(maxsum<tempsum && tempsum>=0){
	                maxsum=tempsum;
	                start=tempstart;
	                end=tempend;
	                tempsum=0;
	                tempstart=i;
	            }
	            else if(maxsum==tempsum &&  tempsum>=0){
	                    if(end-start<tempend-tempstart){
    	                    maxsum=tempsum;
        	                start=tempstart;
        	                end=tempend;
        	                 tempsum=0;
        	                 tempstart=i;
	                    }
	                    else if(end-start==tempend-tempstart && tempsum>=0){
    	                    if(start>tempstart){
    	                        maxsum=tempsum;
            	                start=tempstart;
            	                end=tempend;
            	                tempsum=0;
            	                tempstart=i;
    	                    }
	                }
	                else if(tempsum==0){
	                    end=tempend;
	                }
	            }
	        }
	    }
	    if(flag==0){
	        end=0;
	    }
	    List<Integer> temp= a.subList(start,end);
	    ArrayList<Integer> res=new ArrayList<Integer>();
	    res.addAll(temp);
	    return res;
	}
	public static void main(String[] args){
		ArrayList<Integer> arg=new ArrayList<Integer>();
		//1967513926, 1540383426, -1303455736, -521595368
		arg.add(1967513926);
		arg.add(1540383426);
		arg.add(-1303455736);
		//arg.add(0);
		arg.add(-521595368);
		arg=maxset(arg);
	}
}

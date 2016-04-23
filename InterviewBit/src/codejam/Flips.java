package codejam;

import java.util.ArrayList;
import java.util.List;

public class Flips {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		int k=3;
		ArrayList temp=new ArrayList<Integer>();
		int i;
		for(i=0;i<10;i++){
			arr[i]=i;
		}
		int size=arr.length;
		int l=size-k;
		while(k>0){
			temp.add(arr[size-k]);
			k--;
		}
		i=0;
		while(i<l){
			temp.add(arr[i]);
		}
		List newlist=temp.subList(0, 3);
		temp.addAll(newlist);
	}

}

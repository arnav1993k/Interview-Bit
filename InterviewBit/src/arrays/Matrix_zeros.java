package arrays;

import java.util.ArrayList;

public class Matrix_zeros {
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int xmax=a.size();
		int ymax=a.get(0).size();
		for(int i=0;i<xmax;i++){
			ArrayList<Integer> row=a.get(i);
			for(int j=0;j<ymax;j++){
				if(row.get(j)==0){
					for(int k=0;k<row.size();k++){
						if(a.get(i).get(k)!=0)
						a.get(i).set(k, 2);
					}
					for(int k=0;k<a.size();k++){
						if(a.get(k).get(j)!=0)
						a.get(k).set(j, 2);
					}
					break;
				}
			}
		}
		for(int i=0;i<xmax;i++){
			ArrayList<Integer> row=a.get(i);
			for(int j=0;j<ymax;j++){
				if(row.get(j)==2){
					a.get(i).set(j, 0);
				}
			}
		}
		System.out.println("k");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<2;i++){
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for(int j=0;j<2;j++){
				if(i==0){
					temp.add(1);
				}
				else
				temp.add(0);
			}
			arr.add(temp);
		}
		setZeroes(arr);
	}

}

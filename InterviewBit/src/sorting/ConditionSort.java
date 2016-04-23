package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class ConditionSort {
	static int[] arr={2,25,9,5,0};
	public class NumberComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			String alt1=o1.toString();
			String alt2=o2.toString();
			int rem1=Integer.parseInt(alt1+alt2);
			int rem2=Integer.parseInt(alt2+alt1);
			if(rem1>rem2){
				return 1;
			}
			else return 0;
		}
	}
	public static void main(String[] args){
		final Integer[] sorted =null;// ArrayUtils.toObject(arr);
		Arrays.sort(sorted,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				String alt1=o1.toString();
				String alt2=o2.toString();
				int rem1=Integer.parseInt(alt1+alt2);
				int rem2=Integer.parseInt(alt2+alt1);
				if(rem1>rem2){
					return 1;
				}
				else return 0;
			}
		}
		);
	}
}

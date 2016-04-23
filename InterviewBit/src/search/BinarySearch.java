package search;

public class BinarySearch {
	public static int search(int n,int[] a){
		int l=a.length;
		int mid;
		int start=0;
		int end=l-1;
		int i=0;
		while(start<=end){
			mid=(start+end)/2;
			System.out.println(i++);
			if(a[mid]==n)return mid;
			else if(a[mid]<n)start=mid+1;
			else end=mid-1;
		}

		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3,4,5,6,7,8,9,10};
		int n=9;
		System.out.println(search(19,a));
	}

}

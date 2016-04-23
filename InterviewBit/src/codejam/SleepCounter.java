package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SleepCounter {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f =new File("C:\\Users\\arnav\\Desktop\\A-small-attempt0.in");
		InputStream input=new FileInputStream(f);
		Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(input)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int j = 1; j <= t; ++j) {
	    int n = in.nextInt();
		int m=n;
		int k=n;
		int i=2;
		if(n==0){
			System.out.println("Case #" + j + ": INSOMNIA");
			continue;
		}
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		map.put(0, 0);
		map.put(1, 0);
		map.put(2, 0);
		map.put(3, 0);
		map.put(4, 0);
		map.put(5, 0);
		map.put(6, 0);
		map.put(7, 0);
		map.put(8, 0);
		map.put(9, 0);
		while(!map.isEmpty()){
			if(map.containsKey(n%10))
			map.remove(n%10);
			if(map.isEmpty())
				break;
			n=n/10;
			if(n==0){
				n=m*i++;
				k=n;
			}
		}
		System.out.println("Case #" + m + ": "+k);
	    }
	}

}

package algorithms.b;

import java.io.*;
import java.util.*;
class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new FileReader("input.txt"));
		int n = scanner.nextInt();
		
		int[] array = new int[n];
		for(int i=0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		
		if(array[0]>=0 && array[n-1]>=0) {
			System.out.println(array[0] * array[1]);
		} else if(array[0]<0 && array[n-1]<0){
			System.out.println(array[n-2] * array[n-1]);
		} else {
			System.out.println(array[0] * array[n-1]);
		}
	}
}
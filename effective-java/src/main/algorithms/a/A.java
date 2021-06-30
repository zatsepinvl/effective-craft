import java.io.*;
import java.util.*;
public class A {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(new FileReader("input.txt"));
		int n = scanner.nextInt();
		if(n==0) {
			return;
		}
		int[] array = new int[n];
		for(int i=0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		
		int prev = array[0];
		int start = prev;
		int curr;
		for(int i=1; i<n; i++) {
			curr = array[i];
			if(curr-prev > 1) {
				if(start < prev) {
					System.out.println(start+"-"+prev);
				} else {
					System.out.println(start);
				}
				start = curr;
			}
			prev = curr;
		}
		if(start < prev) {
			System.out.println(start+"-"+prev);
		} else {
			System.out.println(start);
		}		
	}
}
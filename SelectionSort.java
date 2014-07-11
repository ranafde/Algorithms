import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SelectionSort {

	public static void selectionSort(int[] a){
		int temp, i, j;
		int smallestIdx = 0;
		
		for(i=0; i<a.length-1; i++){
			for(j=0; j<a.length; j++){
				if(a[i]>a[j])
					smallestIdx = j;
			}
			temp = a[smallestIdx];
			a[smallestIdx] = a[i];
			a[i] = temp;
		}
	}
	
	public static void main(String args[]) throws Exception{
		int[] a = new int[5];
		String str ="";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<a.length; i++){
			str = bf.readLine();
			a[i] = Integer.parseInt(str);
		}
			
		System.out.println("Before sort:");
	
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		selectionSort(a);
	
		System.out.println("After sort:");
		
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	
	}
}
